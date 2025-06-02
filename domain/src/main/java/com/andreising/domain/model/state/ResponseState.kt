package com.andreising.domain.model.state

sealed class ResponseState<out T> {
    data class Success<out T>(val data: T) : ResponseState<T>()
    class Loading<T> : ResponseState<T>()
    data class Error<T>(val message: String) : ResponseState<T>()
}