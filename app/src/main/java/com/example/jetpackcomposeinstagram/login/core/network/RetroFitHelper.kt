package com.example.jetpackcomposeinstagram.login.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitHelper {
    fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")// Terminar con barrita
            .addConverterFactory( GsonConverterFactory.create() )
            .build()
    }
}