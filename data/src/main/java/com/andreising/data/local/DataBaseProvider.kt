package com.andreising.data.local

import android.content.Context
import androidx.room.Room

object DataBaseProvider {
    const val DATABASE_NAME = "data_base_name"

    fun getDataBase(context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
}