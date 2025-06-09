package com.andreising.presentation.screens.scaffold

import androidx.lifecycle.ViewModel
import com.andreising.domain.usecases.local.ObserveFavouriteVacanciesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ScaffoldScreenViewModel @Inject constructor(
    observeFavouriteVacanciesUseCase: ObserveFavouriteVacanciesUseCase
) : ViewModel() {
    val vacancyListSize = observeFavouriteVacanciesUseCase.invoke().map { it.size }
}