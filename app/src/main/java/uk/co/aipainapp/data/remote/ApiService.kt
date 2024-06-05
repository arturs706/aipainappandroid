package uk.co.aipainapp.data.remote

import retrofit2.http.Body
import retrofit2.http.POST
import uk.co.aipainapp.domain.model.LoginRequest
import uk.co.aipainapp.domain.model.LoginResponse
import uk.co.aipainapp.domain.model.SocialLoginRequest

interface ApiService {
    @POST("api/v1/users/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
    @POST("api/v1/users/login/google")
    suspend fun googlelogin(@Body socialLoginRequest: SocialLoginRequest): LoginResponse
    @POST("api/v1/users/login/facebook")
    suspend fun facebooklogin(@Body socialLoginRequest: SocialLoginRequest): LoginResponse

}