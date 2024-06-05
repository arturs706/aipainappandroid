package uk.co.aipainapp.domain.model

data class LoginResponse(
    val email: String? = null,
    val status: String,
    val errorMessage: String? = null
)