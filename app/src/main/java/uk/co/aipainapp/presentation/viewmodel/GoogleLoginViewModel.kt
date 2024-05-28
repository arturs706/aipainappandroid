package uk.co.aipainapp.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task

class GoogleLoginViewModel : ViewModel() {
    var username = mutableStateOf("")
    var password = mutableStateOf("")
    var passwordVisibility = mutableStateOf(true)

    fun onUsernameChange(newUsername: String) {
        username.value = newUsername
    }

    fun onPasswordChange(newPassword: String) {
        password.value = newPassword
    }

    fun togglePasswordVisibility() {
        passwordVisibility.value = !passwordVisibility.value
    }

    fun handleGoogleSignInResult(task: Task<GoogleSignInAccount>?) {
        try {
            val account = task?.getResult(ApiException::class.java)
            if (account != null) {
                Log.e("Google Sign-In", "Google sign-in successful, account: ${account.email}")
            }
        } catch (e: ApiException) {
            Log.e("Google Sign-In", "Google sign-in failed: ${e.message}")
        }
    }

}
