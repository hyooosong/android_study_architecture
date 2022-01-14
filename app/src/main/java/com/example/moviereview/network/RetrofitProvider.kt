package com.example.moviereview.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun <T> provideService(clazz: Class<T>): T = Retrofit.Builder()
    .baseUrl("https://openapi.naver.com")
    .addConverterFactory(GsonConverterFactory.create())
    .client(httpLoggingClient())
    .build()
    .create(clazz)

private fun httpLoggingClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder().addInterceptor(interceptor).build()
}