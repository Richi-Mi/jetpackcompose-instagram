package com.example.jetpackcomposeinstagram.login.data.network

import com.example.jetpackcomposeinstagram.login.data.network.responses.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {
    @GET("v3/0ad93181-a2b8-4c25-a9f4-51f11dfbdb42")
    suspend fun doLogin(): Response<LoginResponse>
}