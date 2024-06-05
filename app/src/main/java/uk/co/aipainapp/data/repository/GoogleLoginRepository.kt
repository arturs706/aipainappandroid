package uk.co.aipainapp.data.repository

import uk.co.aipainapp.domain.model.LoginResponse

interface GoogleLoginRepository {
    suspend fun googlelogin(social_id: String, email: String, full_name: String): LoginResponse

}