package com.andreising.data.remote

import com.andreising.data.remote.api.GoogleDriveApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {
    const val BASE_URL = "https://drive.usercontent.google.com/"

    fun getRetrofitInstance() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getGoogleDriveApi(retrofit: Retrofit) = retrofit.create(GoogleDriveApi::class.java)
}

