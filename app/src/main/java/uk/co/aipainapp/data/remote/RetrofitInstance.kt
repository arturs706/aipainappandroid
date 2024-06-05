package uk.co.aipainapp.data.remote

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun provideRetrofit(): Retrofit {
    val okHttpClient = OkHttpClient.Builder().build()
    return Retrofit.Builder()
        .baseUrl("http://10.0.2.2:2001/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}