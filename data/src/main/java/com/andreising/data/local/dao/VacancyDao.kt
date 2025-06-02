package com.andreising.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.andreising.data.local.entity.VacancyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VacancyDao {

    @Query("SELECT * FROM vacancies")
    fun observeVacancyList(): Flow<List<VacancyEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vacancy: VacancyEntity)

    @Delete
    suspend fun delete(vacancy: VacancyEntity)

    @Query("SELECT EXISTS(SELECT 1 FROM vacancies WHERE id = :id)")
    suspend fun isSaved(id: String): Boolean
}