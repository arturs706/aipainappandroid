package uk.co.aipainapp.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uk.co.aipainapp.data.repository.LoginRepository
import uk.co.aipainapp.domain.model.LoginErrorResponse
import uk.co.aipainapp.domain.model.LoginResponse

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {
    val username = mutableStateOf("")
    val password = mutableStateOf("")
    val passwordVisibility = mutableStateOf(true)
    val isLoading = mutableStateOf(false)
    val errorMessage = mutableStateOf("")
    val showModal = mutableStateOf(false)
    val loginResponse = mutableStateOf<LoginResponse?>(null)
    val loginErrorResponse = mutableStateOf<LoginErrorResponse?>(null)
    fun onUsernameChange(newUsername: String) {
        username.value = newUsername
    }

    fun onPasswordChange(newPassword: String) {
        password.value = newPassword
    }

    fun togglePasswordVisibility() {
        passwordVisibility.value = !passwordVisibility.value
    }

    fun login() {
        viewModelScope.launch {
            isLoading.value = true
            errorMessage.value = ""
            loginResponse.value = null
            loginErrorResponse.value = null

            try {
                val response = loginRepository.login(username.value, password.value)
                if (response.status == "success") {
                    loginResponse.value = response
                    showLoginSuccessDialog()
                } else {
                    showLoginErrorDialog()
                }
            } catch (e: Exception) {
                if (e.message.equals("HTTP 401 Unauthorized")){
                    loginErrorResponse.value = LoginErrorResponse("Email or password is wrong", "error")
                    showLoginErrorDialog()
                } else {
                    loginErrorResponse.value = LoginErrorResponse(e.message.toString(), "error")
                    showLoginErrorDialog()
                }

            }

            isLoading.value = false
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