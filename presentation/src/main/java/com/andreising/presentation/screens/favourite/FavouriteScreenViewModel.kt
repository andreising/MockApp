package com.andreising.presentation.screens.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreising.domain.model.VacancyMainModel
import com.andreising.domain.usecases.local.ObserveFavouriteVacanciesUseCase
import com.andreising.domain.usecases.local.ToggleItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteScreenViewModel @Inject constructor(
    observeFavouriteVacanciesUseCase: ObserveFavouriteVacanciesUseCase,
    private val toggleItemUseCase: ToggleItemUseCase
) : ViewModel() {
    val vacancyList = observeFavouriteVacanciesUseCase.invoke()

    fun onItemToggled(vacancyMainModel: VacancyMainModel) = viewModelScope.launch {
        toggleItemUseCase.invoke(vacancyMainModel)
    }
}