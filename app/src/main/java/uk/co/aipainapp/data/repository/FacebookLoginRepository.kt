package uk.co.aipainapp.data.repository

import uk.co.aipainapp.domain.model.LoginResponse

interface FacebookLoginRepository {
    suspend fun facebooklogin(social_id: String, email: String, full_name: String): LoginResponse

}