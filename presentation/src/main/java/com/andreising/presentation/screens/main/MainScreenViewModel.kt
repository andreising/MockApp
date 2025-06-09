package com.andreising.presentation.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreising.domain.model.VacancyMainModel
import com.andreising.domain.usecases.combine.GetResponseStateWithFavouritesUseCase
import com.andreising.domain.usecases.local.ToggleItemUseCase
import com.andreising.domain.usecases.remote.LoadInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    getResponseStateWithFavouritesUseCase: GetResponseStateWithFavouritesUseCase,
    private val loadInfoUseCase: LoadInfoUseCase,
    private val toggleItemUseCase: ToggleItemUseCase
) : ViewModel() {

    val responseState = getResponseStateWithFavouritesUseCase.invoke()

    fun loadData() = viewModelScope.launch { loadInfoUseCase.invoke() }

    fun toggleItem(vacancyMainModel: VacancyMainModel) = viewModelScope.launch {
        toggleItemUseCase.invoke(vacancyMainModel)
    }
}