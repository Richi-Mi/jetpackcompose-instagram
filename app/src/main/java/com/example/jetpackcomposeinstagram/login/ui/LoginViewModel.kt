package com.example.jetpackcomposeinstagram.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _email = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()
    private val _isLoginEnabled = MutableLiveData<Boolean>()

    val email : LiveData<String> = _email
    val password : LiveData<String> = _password
    val isLogEnabled : LiveData<Boolean> = _isLoginEnabled

    fun onLoginChanged( email: String, password : String ) {
        _email.value = email
        _password.value = password

        _isLoginEnabled.value = enableLogin( email, password )
    }

    fun enableLogin( email: String, pass : String ) = Patterns.EMAIL_ADDRESS.matcher( email ).matches() && pass.length > 6 // Patterns - Expresiones regulares
}