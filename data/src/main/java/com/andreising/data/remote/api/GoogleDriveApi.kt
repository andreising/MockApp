package com.andreising.data.remote.api

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleDriveApi {
    @GET("u/0/uc?export=download")
    suspend fun downloadFile(
        @Query("id") fileId: String
    ): Response<ResponseBody>
}