package com.example.quiz12maktab

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiService {
    @GET("users/MENasri23")
    fun getMessage():Call<User>

    companion object {
        var BASE_URL="https://api.github.com/"

        fun create():ApiService{
            val retrofit=Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}