package com.andreising.domain.usecases.combine

import com.andreising.domain.model.RemoteResponse
import com.andreising.domain.model.state.ResponseState
import com.andreising.domain.usecases.local.ObserveFavouriteVacanciesUseCase
import com.andreising.domain.usecases.remote.ObserveResponseStateUseCase
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetResponseStateWithFavouritesUseCase @Inject constructor(
    private val observeResponseStateUseCase: ObserveResponseStateUseCase,
    private val observeFavouriteVacanciesUseCase: ObserveFavouriteVacanciesUseCase
) {
    operator fun invoke() = combine(
        observeResponseStateUseCase.invoke(),
        observeFavouriteVacanciesUseCase.invoke()
    ) { responseState, vacancyLocalList ->
        when (responseState) {
            is ResponseState.Error -> ResponseState.Error(responseState.message)
            is ResponseState.Loading -> ResponseState.Loading
            is ResponseState.Success -> ResponseState.Success(
                RemoteResponse(
                    responseState.data.optionList,
                    responseState.data.vacancyList.map { vacancy ->
                        vacancy.copy(
                            isFavourite = vacancyLocalList.any { it.id == vacancy.id }
                        )
                    })
            )
        }
    }
}