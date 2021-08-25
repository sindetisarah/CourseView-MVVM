package com.example.akirachix_registration.ui

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.akirachix_registration.R
import com.example.akirachix_registration.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    val userViewModel: UserViewModel by viewModels()

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}