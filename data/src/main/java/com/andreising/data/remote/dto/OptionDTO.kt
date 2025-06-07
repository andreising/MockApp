package com.andreising.data.remote.dto

import com.google.gson.annotations.SerializedName

data class OptionDTO(
    @SerializedName("id") val id: String?,
    @SerializedName("title") val title: String,
    @SerializedName("button") val button: ButtonDTO?,
    @SerializedName("link") val link: String
)
