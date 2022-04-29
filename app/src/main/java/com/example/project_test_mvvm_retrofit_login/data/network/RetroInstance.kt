package com.example.project_test_mvvm_retrofit_login.data.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object{
        private const val BASE_URL = "https://api.beberia.me/api/v1/auth/"

        fun getRetroInstance(): Retrofit{
            val gson = GsonBuilder().setLenient().create()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
    }
}