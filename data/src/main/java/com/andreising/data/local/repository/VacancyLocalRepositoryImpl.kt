package com.andreising.data.local.repository

import com.andreising.data.local.dao.VacancyDao
import com.andreising.data.local.mappers.toDomain
import com.andreising.data.local.mappers.toEntity
import com.andreising.domain.model.VacancyMainModel
import com.andreising.domain.repository.VacancyLocalRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class VacancyLocalRepositoryImpl(
    private val vacancyDao: VacancyDao
) : VacancyLocalRepository {

    private val coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    override fun observeSavedVacancyList(): StateFlow<List<VacancyMainModel>> =
        vacancyDao.observeVacancyList()
            .map { list ->
                list.map { entity ->
                    entity.toDomain(isFavourite = true)
                }
            }
            .stateIn(
                scope = coroutineScope,
                started = SharingStarted.Lazily,
                initialValue = emptyList()
            )

    override suspend fun toggleItem(vacancyMainModel: VacancyMainModel) {
        val isSaved = vacancyDao.isSaved(vacancyMainModel.id)
        if (isSaved) {
            vacancyDao.delete(vacancyMainModel.toEntity())
        } else {
            vacancyDao.insert(vacancyMainModel.toEntity())
        }
    }
}