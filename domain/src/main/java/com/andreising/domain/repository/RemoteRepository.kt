package com.andreising.domain.repository

import com.andreising.domain.model.state.ResponseState
import kotlinx.coroutines.flow.StateFlow

interface RemoteRepository {
    suspend fun loadInfo()
    val loadState: StateFlow<ResponseState>
}