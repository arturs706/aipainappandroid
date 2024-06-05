package uk.co.aipainapp.presentation.viewmodel

import android.os.Bundle
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.login.LoginManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import uk.co.aipainapp.data.repository.FacebookLoginRepository
import uk.co.aipainapp.domain.model.LoginErrorResponse
import uk.co.aipainapp.domain.model.LoginResponse

class FacebookLoginViewModel(private val loginRepository: FacebookLoginRepository) : ViewModel() {
    val showModal = mutableStateOf(false)
    val loginResponse = mutableStateOf<LoginResponse?>(null)
    val loginErrorResponse = mutableStateOf<LoginErrorResponse?>(null)

    private val _accessToken = mutableStateOf<AccessToken?>(null)
    val accessToken get() = _accessToken.value

    fun handleLoginResult(accessToken: AccessToken?) {
        _accessToken.value = accessToken
        accessToken?.let {
            viewModelScope.launch {
                fetchUserData(it)
            }
        }
    }

    private suspend fun fetchUserData(accessToken: AccessToken) {
        loginResponse.value = null
        loginErrorResponse.value = null

        val request = GraphRequest.newMeRequest(accessToken) { jsonObject, response ->
            try {
                val email = jsonObject?.getString("email")
                val id = jsonObject?.getString("id")
                val fullName = jsonObject?.getString("name")

                if (email != null) {
                    viewModelScope.launch(Dispatchers.IO) {
                        try {
                            val response = loginRepository.facebooklogin(id.toString(), email.toString(), fullName.toString())
                            withContext(Dispatchers.Main) {
                                if (response.status == "success") {
                                    loginResponse.value = LoginResponse(email, "success")
                                    showLoginSuccessDialog()
                                } else {
                                    showLoginErrorDialog()
                                }
                            }
                        } catch (e: Exception) {
                            withContext(Dispatchers.Main) {
                                if (e.message == "HTTP 409 Conflict") {
                                    loginErrorResponse.value = LoginErrorResponse("Use different method of login", "error")
                                } else {
                                    loginErrorResponse.value = LoginErrorResponse(e.message ?: "Unknown error", "error")
                                }
                                showLoginErrorDialog()
                            }
                        }
                    }
                } else {
                    loginErrorResponse.value = LoginErrorResponse("Failed to retrieve email", "error")
                    showLoginErrorDialog()
                }
            } catch (e: JSONException) {
                loginErrorResponse.value = LoginErrorResponse("Failed to parse response", "error")
                showLoginErrorDialog()
            }
        }

        val parameters = Bundle().apply {
            putString("fields", "email,name")
        }
        request.parameters = parameters
        request.executeAsync()
    }

    fun logout() {
        LoginManager.getInstance().logOut()
        _accessToken.value = null
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
