package com.andreising.domain.usecases.local

import com.andreising.domain.repository.VacancyLocalRepository
import javax.inject.Inject

class ObserveFavouriteVacanciesUseCase @Inject constructor(
    private val repository: VacancyLocalRepository
) {
    operator fun invoke() = repository.observeSavedVacancyList()
}