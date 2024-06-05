package uk.co.aipainapp.data.repository

import uk.co.aipainapp.data.remote.ApiService
import uk.co.aipainapp.domain.model.LoginRequest
import uk.co.aipainapp.domain.model.LoginResponse

class LoginRepositoryImpl(private val apiService: ApiService) : LoginRepository {
    override suspend fun login(email: String, password: String): LoginResponse {
        val loginRequest = LoginRequest(email, password)
        return apiService.login(loginRequest)
    }
}