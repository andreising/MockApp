package com.andreising.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Поле isFavourite в MainModel – логически выведенное: если вакансия сохранена — это избранное.
 * Поэтому оно не хранится явно в БД, а определяется по факту присутствия в таблице.
 * */
@Entity(tableName = "vacancies")
data class VacancyEntity(
    @PrimaryKey val id: String,
    val lookingNumber: Int?,
    val title: String,
    val town: String,
    val company: String,
    val experienceText: String,
    val publishedDate: String
)