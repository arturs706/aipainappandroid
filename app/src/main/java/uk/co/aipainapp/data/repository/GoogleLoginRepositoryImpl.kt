package uk.co.aipainapp.data.repository

import uk.co.aipainapp.data.remote.ApiService
import uk.co.aipainapp.domain.model.LoginResponse
import uk.co.aipainapp.domain.model.SocialLoginRequest

class GoogleLoginRepositoryImpl(private val apiService: ApiService): GoogleLoginRepository {
    override suspend fun googlelogin(
        social_id: String,
        email: String,
        full_name: String
    ): LoginResponse {
        val loginRequest = SocialLoginRequest(social_id, email, full_name)
        return apiService.googlelogin(loginRequest)
    }
}
