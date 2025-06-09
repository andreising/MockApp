package com.andreising.domain.usecases.remote

import com.andreising.domain.repository.RemoteRepository
import javax.inject.Inject

class ObserveResponseStateUseCase @Inject constructor(
    private val repository: RemoteRepository
) {
    operator fun invoke() = repository.loadState
}