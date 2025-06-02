package com.andreising.domain.repository

import com.andreising.domain.model.VacancyMainModel
import kotlinx.coroutines.flow.StateFlow

interface VacancyLocalRepository {
    fun getSavedVacancy(): StateFlow<List<VacancyMainModel>>
    suspend fun toggleItem(vacancyMainModel: VacancyMainModel)
}