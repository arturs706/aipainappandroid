package uk.co.aipainapp.data.repository

import uk.co.aipainapp.data.remote.ApiService
import uk.co.aipainapp.domain.model.LoginResponse
import uk.co.aipainapp.domain.model.SocialLoginRequest

class FacebookLoginRepositoryImpl(private val apiService: ApiService) : FacebookLoginRepository {
    override suspend fun facebooklogin(
        social_id: String,
        email: String,
        full_name: String
    ): LoginResponse {
        val response = SocialLoginRequest(social_id, email, full_name)
        return apiService.facebooklogin(response)
    }
}