package com.andreising.mockapp.di

import com.andreising.data.local.repository.VacancyLocalRepositoryImpl
import com.andreising.data.remote.repository.RemoteRepositoryImpl
import com.andreising.domain.repository.RemoteRepository
import com.andreising.domain.repository.VacancyLocalRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MainModule {

    @Singleton
    @Binds
    abstract fun provideLocalRepository(impl: VacancyLocalRepositoryImpl): VacancyLocalRepository

    @Singleton
    @Binds
    abstract fun provideRemoteRepository(impl: RemoteRepositoryImpl): RemoteRepository
}