package com.example.crimsoneyes.network

import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {

    private val client by lazy {
<<<<<<< HEAD
        val logger = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
=======
        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        OkHttpClient.Builder().addInterceptor(logger).build()
>>>>>>> 32cbb9d (Ready)
    }

    private val json by lazy {
        Json {
            ignoreUnknownKeys = true
            explicitNulls = false
        }
    }

<<<<<<< HEAD

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
=======
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()

                .baseUrl("http://192.168.1.94:8080/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
>>>>>>> 32cbb9d (Ready)
    }

    fun <T> create(service: Class<T>): T = retrofit.create(service)
    inline fun <reified T> create(): T = retrofit.create(T::class.java)
}
<<<<<<< HEAD

=======
>>>>>>> 32cbb9d (Ready)
