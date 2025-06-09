package com.andreising.data.remote.api

import com.andreising.data.remote.dto.ApiResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleDriveApi {
    @GET("u/0/uc?export=download")
    suspend fun getVacancyAndOptionInfo(
        @Query("id") fileId: String
    ): Response<ApiResponseDto>
}