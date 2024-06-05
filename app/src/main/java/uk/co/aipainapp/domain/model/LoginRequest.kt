package uk.co.aipainapp.domain.model

data class LoginRequest(
    val email: String,
    val passwd: String
)