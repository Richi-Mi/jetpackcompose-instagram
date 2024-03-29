package com.example.jetpackcomposeinstagram.login

import com.example.jetpackcomposeinstagram.login.data.network.LoginService

class LoginRepository {
    val api = LoginService()

    suspend fun doLogin( user: String, password: String ) : Boolean {
        return api.doLogin( user, password )
    }
}