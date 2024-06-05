package uk.co.aipainapp.domain.model

data class SocialLoginRequest (
    val social_id: String,
    val email: String,
    val full_name: String
)