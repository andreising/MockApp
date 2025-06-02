package com.andreising.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AddressDTO(
    @SerializedName("town") val town: String
)
