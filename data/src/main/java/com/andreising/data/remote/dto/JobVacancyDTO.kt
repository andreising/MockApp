package com.andreising.data.remote.dto

import com.google.gson.annotations.SerializedName

data class JobVacancyDTO(
    @SerializedName("id") val id: String,
    @SerializedName("lookingNumber") val lookingNumber: Int,
    @SerializedName("title") val title: String,
    @SerializedName("address") val address: AddressDTO,
    @SerializedName("company") val company: String,
    @SerializedName("experience") val experience: ExperienceDTO,
    @SerializedName("publishedDate") val publishedDate: String
)
