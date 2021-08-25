package com.example.akirachix_registration.models

import android.content.SharedPreferences
import android.content.Context
import com.example.akirachix_registration.R

class SessionManager(context: Context) {
    private var preferens: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "ACCESS_TOKEN"
    }

    fun saveAuthentication(token: String) {
        val editor = preferens.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun fetchAuthentication(): String? {
        return preferens.getString(USER_TOKEN, null)
    }

}