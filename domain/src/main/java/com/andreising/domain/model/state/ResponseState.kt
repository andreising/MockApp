package com.andreising.domain.model.state

import com.andreising.domain.model.RemoteResponse

sealed class ResponseState {
    data class Success(val data: RemoteResponse) : ResponseState()
    object Loading: ResponseState()
    data class Error(val message: String) : ResponseState()
}