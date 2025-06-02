package com.andreising.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ApiResponseDto(
    @SerializedName("offers") val offers: List<OptionDTO>,
    @SerializedName("vacancies") val vacancies: List<JobVacancyDTO>
)
