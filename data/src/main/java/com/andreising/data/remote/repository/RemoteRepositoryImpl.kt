package com.andreising.data.remote.repository

import com.andreising.data.remote.api.GoogleDriveApi
import com.andreising.data.remote.dto.ApiResponseDto
import com.andreising.data.remote.mapper.toDomain
import com.andreising.domain.model.state.ResponseState
import com.andreising.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.json.Json
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val googleDriveApi: GoogleDriveApi
) : RemoteRepository {

    private val _remoteResponseState =
        MutableStateFlow<ResponseState>(ResponseState.Loading)

    override suspend fun loadInfo() {
        _remoteResponseState.value = ResponseState.Loading
        try {
            val response = googleDriveApi.downloadFile(DEFAULT_FILE_ID)
            if (response.isSuccessful) {
                val jsonString = response.body()?.string()
                if (jsonString != null) {
                    val parsed = Json.decodeFromString<ApiResponseDto>(jsonString)
                    _remoteResponseState.value = ResponseState.Success(parsed.toDomain())
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

    override fun getLoadState() = _remoteResponseState.asStateFlow()

    companion object {
        private const val DEFAULT_FILE_ID = "1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r"
    }
}