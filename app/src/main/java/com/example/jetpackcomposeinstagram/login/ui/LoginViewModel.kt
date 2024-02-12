package com.example.jetpackcomposeinstagram.login.ui

import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeinstagram.login.domain.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    val loginUseCase = LoginUseCase()

    private val _email = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()
    private val _isLoginEnabled = MutableLiveData<Boolean>()
    private val _isLoading = MutableLiveData<Boolean>()

    val email : LiveData<String> = _email
    val password : LiveData<String> = _password
    val isLogEnabled : LiveData<Boolean> = _isLoginEnabled
    val isLoaging : LiveData<Boolean> = _isLoading

    fun onLoginChanged( email: String, password : String ) {
        _email.value = email
        _password.value = password

        _isLoginEnabled.value = enableLogin( email, password )
    }

    fun enableLogin( email: String, pass : String ) = Patterns.EMAIL_ADDRESS.matcher( email ).matches() && pass.length > 6 // Patterns - Expresiones regulares
    fun onLoginSelected( onSucess: () -> Unit ) {
        viewModelScope.launch {
            _isLoading.value = true
            val res = loginUseCase( email!!.value!!, password!!.value!! )
            if( res ) {
                // Navegar a la siguiente pantalla
                onSucess()
            }
        }
    }
}