package com.andreising.data.remote.repository

import com.andreising.data.remote.api.GoogleDriveApi
import com.andreising.data.remote.mapper.toDomain
import com.andreising.domain.model.state.ResponseState
import com.andreising.domain.repository.RemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val googleDriveApi: GoogleDriveApi
) : RemoteRepository {

    private val _remoteResponseState =
        MutableStateFlow<ResponseState>(ResponseState.Loading)
    override val loadState: StateFlow<ResponseState>
        get() = _remoteResponseState

    override suspend fun loadInfo() = withContext(Dispatchers.IO) {
        _remoteResponseState.value = ResponseState.Loading
        try {
            val response = googleDriveApi.getVacancyAndOptionInfo(DEFAULT_FILE_ID)
            if (response.isSuccessful) {
                val apiResponse = response.body()
                if (apiResponse != null) {
                    _remoteResponseState.value = ResponseState.Success(apiResponse.toDomain())
                } else {
                    _remoteResponseState.value = ResponseState.Error("Пустой ответ")
                }
            } else {
                _remoteResponseState.value =
                    ResponseState.Error("Ошибка загрузки: ${response.code()}")
            }
        } catch (e: Exception) {
            _remoteResponseState.value = ResponseState.Error("Ошибка: ${e.message}")
        }
    }

    companion object {
        private const val DEFAULT_FILE_ID = "1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r"
    }
}