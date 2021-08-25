package com.example.akirachix_registration.repository

import com.example.akirachix_registration.api.ApiClient
import com.example.akirachix_registration.api.ApiInterface
import com.example.akirachix_registration.models.LoginRequest
import com.example.akirachix_registration.models.LoginResponse
import com.example.akirachix_registration.models.RegistrationRequest
import com.example.akirachix_registration.models.RegistrationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    var apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun registerStudent(registrationRequest: RegistrationRequest):
            Response<RegistrationResponse> = withContext(Dispatchers.IO){
        var response = apiInterface.registerStudent(registrationRequest)
        return@withContext response
    }

    suspend fun login(logInRequest: LoginRequest):Response<LoginResponse> =
        withContext(Dispatchers.IO){
            var response = apiInterface.logInStudent(logInRequest)
            return@withContext response
        }
}