package com.andreising.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ButtonDTO(
    @SerializedName("text") val text: String
)
