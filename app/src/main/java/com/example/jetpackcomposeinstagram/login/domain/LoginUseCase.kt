package com.example.jetpackcomposeinstagram.login.domain

import com.example.jetpackcomposeinstagram.login.LoginRepository

class LoginUseCase {
    val repository = LoginRepository()

    suspend operator fun invoke(user: String, password: String) : Boolean {
        return repository.doLogin( user, password )
    }
}