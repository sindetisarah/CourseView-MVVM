package com.example.akirachix_registration.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.akirachix_registration.models.Course
import androidx.lifecycle.viewModelScope
import com.example.akirachix_registration.repository.CourseRepository
import kotlinx.coroutines.launch

class CoursesViewModel: ViewModel() {
    var coursesLiveData = MutableLiveData<List<Course>>()
    var coursesFailedLiveData = MutableLiveData<String>()
    var coursesRepository = CourseRepository()

    fun coursesList(accessToken: String){
        viewModelScope.launch {
            var response = coursesRepository.courses(accessToken)
            if (response.isSuccessful){
                coursesLiveData.postValue(response.body())
            }
            else{
                coursesFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}