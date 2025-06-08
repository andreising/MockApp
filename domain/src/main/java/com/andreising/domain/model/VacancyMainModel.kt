package com.andreising.domain.model

data class VacancyMainModel(
    val id: String,
    val lookingNumber: Int,
    val title: String,
    val isFavourite: Boolean,
    val town: String,
    val company: String,
    val experienceText: String,
    val publishedDate: String
)
