package com.example.jetpackcomposeinstagram.login.data.network

import com.example.jetpackcomposeinstagram.login.core.network.RetroFitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginService {
    private val retrofit = RetroFitHelper.getRetrofit()

    suspend fun doLogin( user: String, password: String ) : Boolean{
        return withContext( Dispatchers.IO ) {
            val response = retrofit.create( LoginClient::class.java ).doLogin()
            //val isS = response.body()!!.success

            //isS
            response.body()?.success ?: false
        }
    }
}