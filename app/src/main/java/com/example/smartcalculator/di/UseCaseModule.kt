package com.example.smartcalculator.di

import com.example.smartcalculator.data.repository.HistoryRepository
import com.example.smartcalculator.domain.usecase.history.SaveHistoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideSaveHistoryUseCase(historyRepository: HistoryRepository): SaveHistoryUseCase {
        return SaveHistoryUseCase(historyRepository)
    }

    // Добавьте другие Use Cases по мере необходимости
}