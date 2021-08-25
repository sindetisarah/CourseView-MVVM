package com.example.akirachix_registration.repository

import com.example.akirachix_registration.api.ApiClient
import com.example.akirachix_registration.api.ApiInterface
import com.example.akirachix_registration.models.Course
import com.example.akirachix_registration.models.EnrolmentResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CourseRepository {
    var apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun courses(accessToken: String): Response<List<Course>> =
        withContext(Dispatchers.IO){

            var response = apiInterface.studentCourses((accessToken))
            return@withContext response
        }
    suspend fun enrol(accessToken: String): Response<EnrolmentResponse> =
        withContext(Dispatchers.IO){
            var enrol = apiInterface.enrol(accessToken)
            return@withContext enrol
        }
}