package com.andreising.data.remote.mapper

import com.andreising.data.remote.dto.ApiResponseDto
import com.andreising.data.remote.dto.JobVacancyDTO
import com.andreising.data.remote.dto.OptionDTO
import com.andreising.domain.model.OptionMainModel
import com.andreising.domain.model.Recommendation
import com.andreising.domain.model.RemoteResponse
import com.andreising.domain.model.VacancyMainModel

fun OptionDTO.toDomain() = OptionMainModel(
    recommendation = Recommendation.getRecommendationByString(id),
    title = title.trim(),
    buttonText = button?.text,  // Если button есть, берём его текст
    link = link
)

fun JobVacancyDTO.toDomain() = VacancyMainModel(
    id = id,
    lookingNumber = lookingNumber,
    isFavourite = false,
    town = address.town,
    company = company,
    experienceText = experience.previewText,
    publishedDate = publishedDate
)

fun ApiResponseDto.toDomain() = RemoteResponse(
    optionList = offers.map { it.toDomain() },
    vacancyList = vacancies.map { it.toDomain() }
)