package com.andreising.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.andreising.data.local.dao.VacancyDao
import com.andreising.data.local.entity.VacancyEntity

@Database(entities = [VacancyEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun vacancyDao(): VacancyDao
}