package com.andreising.mockapp.di

import android.content.Context
import com.andreising.data.local.AppDatabase
import com.andreising.data.local.DataBaseProvider
import com.andreising.data.remote.RetrofitProvider
import com.andreising.data.remote.api.GoogleDriveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideRetrofit(): Retrofit = RetrofitProvider.getRetrofitInstance()

    @Provides
    fun provideGoogleApi(retrofit: Retrofit): GoogleDriveApi =
        RetrofitProvider.getGoogleDriveApi(retrofit)

    @Provides
    @Singleton
    fun provideMainDataBase(@ApplicationContext context: Context): AppDatabase {
        return DataBaseProvider.getDataBase(context)
    }
}