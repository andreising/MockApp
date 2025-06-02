package com.andreising.data.local.mappers

import com.andreising.data.local.entity.VacancyEntity
import com.andreising.domain.model.VacancyMainModel

fun VacancyEntity.toDomain(isFavourite: Boolean) = VacancyMainModel(
    id = id,
    lookingNumber = lookingNumber,
    isFavourite = isFavourite,
    town = town,
    company = company,
    experienceText = experienceText,
    publishedDate = publishedDate
)

fun VacancyMainModel.toEntity() = VacancyEntity(
    id = id,
    lookingNumber = lookingNumber,
    town = town,
    company = company,
    experienceText = experienceText,
    publishedDate = publishedDate
)