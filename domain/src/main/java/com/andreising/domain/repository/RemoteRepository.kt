package com.andreising.domain.repository

import com.andreising.domain.model.RemoteResponse
import com.andreising.domain.model.state.ResponseState
import kotlinx.coroutines.flow.StateFlow

interface RemoteRepository {
    suspend fun loadInfo()
    fun getLoadState(): StateFlow<ResponseState<RemoteResponse>>
}