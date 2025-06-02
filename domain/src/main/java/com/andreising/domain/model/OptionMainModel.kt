package com.andreising.domain.model

data class OptionMainModel(
    val recommendation: Recommendation,
    val title: String,
    val buttonText: String?,
    val link: String
)
