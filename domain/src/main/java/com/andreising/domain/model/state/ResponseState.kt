package com.andreising.domain.model.state

sealed class ResponseState<out T> {
    data class Success<out T>(val data: T) : ResponseState<T>()
    data object Loading : ResponseState<Unit>()
    data class Error(val message: String) : ResponseState<Nothing>()
}