package uk.co.aipainapp.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import uk.co.aipainapp.data.repository.GoogleLoginRepository
import uk.co.aipainapp.data.repository.LoginRepository
import uk.co.aipainapp.domain.model.LoginErrorResponse
import uk.co.aipainapp.domain.model.LoginResponse

class GoogleLoginViewModel(private val loginRepository: GoogleLoginRepository) : ViewModel() {
    val showModal = mutableStateOf(false)
    val loginResponse = mutableStateOf<LoginResponse?>(null)
    val loginErrorResponse = mutableStateOf<LoginErrorResponse?>(null)

    suspend fun handleGoogleSignInResult(task: Task<GoogleSignInAccount>?) {
        loginResponse.value = null
        loginErrorResponse.value = null

        try {
            val account = task?.getResult(ApiException::class.java)
            if (account != null) {
                var fullName = account.givenName + account.familyName
               try {
                   val response = loginRepository.googlelogin(account.id.toString(), account.email.toString(), fullName)
                   if (response.status == "success") {
                       loginResponse.value = LoginResponse("${account.email}\"", "success")
                       showLoginSuccessDialog()
                   } else {
                       showLoginErrorDialog()
                   }
               } catch (e: Exception){
                   if (e.message.equals("HTTP 409 Conflict")){
                       loginErrorResponse.value = LoginErrorResponse("Use different method of login", "error")
                       showLoginErrorDialog()
                   } else {
                       loginErrorResponse.value = LoginErrorResponse("${e.message}\"", "error")
                       showLoginErrorDialog()
                   }
               }
            }
        } catch (e: ApiException) {
            Log.e("Google Sign-In", "Google sign-in failed: ${e.message}")
            loginErrorResponse.value = LoginErrorResponse("${e.message}\"", "error")
            showLoginErrorDialog()

        }
    }
    private fun showLoginSuccessDialog() {
        showModal.value = true
    }

    private fun showLoginErrorDialog() {
        showModal.value = true
    }

    fun dismissLoginSuccessDialog() {
        showModal.value = false
    }
}
