package com.example.akirachix_registration.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.akirachix_registration.models.LoginRequest
import com.example.akirachix_registration.models.LoginResponse
import com.example.akirachix_registration.repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    var logInLiveData = MutableLiveData<LoginResponse>()
    var logInErrorLiveData = MutableLiveData<String>()
    var userRepository = UserRepository()

    fun logIn(logInRequest: LoginRequest){
        viewModelScope.launch {
            var response = userRepository.login(logInRequest)
            if (response.isSuccessful){
                logInLiveData.postValue(response.body())
            }
            else{
                logInErrorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}