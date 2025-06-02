package com.andreising.domain.usecases.local

import com.andreising.domain.model.VacancyMainModel
import com.andreising.domain.repository.VacancyLocalRepository
import javax.inject.Inject

class ToggleItemUseCase @Inject constructor(
    private val repository: VacancyLocalRepository
) {
    suspend operator fun invoke(vacancyMainModel: VacancyMainModel) =
        repository.toggleItem(vacancyMainModel)
}