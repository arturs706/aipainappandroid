package uk.co.aipainapp.data.repository

import uk.co.aipainapp.domain.model.LoginResponse

interface LoginRepository {
    suspend fun login(email: String, passwd: String): LoginResponse
}