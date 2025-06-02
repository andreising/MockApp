package com.andreising.domain.usecases.remote

import com.andreising.domain.repository.RemoteRepository
import javax.inject.Inject

class LoadInfoUseCase@Inject constructor(
    private val repository: RemoteRepository
) {
    suspend operator fun invoke() = repository.loadInfo()
}