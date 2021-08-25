package com.example.akirachix_registration.api

import com.example.akirachix_registration.models.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register")
    suspend fun registerStudent(@Body registrationRequest: RegistrationRequest): Response<RegistrationResponse>

    @POST("/students/login")
    suspend fun logInStudent(@Body logInRequest: LoginRequest): Response<LoginResponse>

    @GET("/courses")
    suspend fun studentCourses(@Header("Authorization") token: String): Response<List<Course>>

    @POST("/enrolments")
    suspend fun enrol(@Header("Authorization") token: String): Response<EnrolmentResponse>
}