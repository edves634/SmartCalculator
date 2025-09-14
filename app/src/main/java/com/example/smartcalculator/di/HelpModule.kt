package com.example.smartcalculator.di

import com.example.smartcalculator.data.repository.HelpRepository
import com.example.smartcalculator.data.repository.HelpRepositoryImpl
import com.example.smartcalculator.domain.usecase.help.GetHelpUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HelpModule {
    @Provides
    @Singleton
    fun provideHelpRepository(): HelpRepository {
        return HelpRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideGetHelpUseCase(helpRepository: HelpRepository): GetHelpUseCase {
        return GetHelpUseCase(helpRepository)
    }
}