package com.example.smartcalculator.di

import com.example.smartcalculator.data.local.database.dao.AlgebraicHistoryDao
import com.example.smartcalculator.data.local.database.dao.GraphicHistoryDao
import com.example.smartcalculator.data.local.database.dao.ProgrammerHistoryDao
import com.example.smartcalculator.data.local.database.dao.StatisticalHistoryDao
import com.example.smartcalculator.data.repository.HelpRepository
import com.example.smartcalculator.data.repository.HistoryRepository
import com.example.smartcalculator.data.repository.HistoryRepositoryImpl
import com.example.smartcalculator.util.Converters
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideHistoryRepository(
        algebraicDao: AlgebraicHistoryDao,
        graphicDao: GraphicHistoryDao,
        programmerDao: ProgrammerHistoryDao,
        statisticalDao: StatisticalHistoryDao,
        converters: Converters
    ): HistoryRepository {
        return HistoryRepositoryImpl(
            algebraicDao, graphicDao, programmerDao, statisticalDao, converters
        )
    }

    @Provides
    @Singleton
    fun provideHelpRepository(): HelpRepository {
        return HelpRepositoryImpl()
    }

    // Аналогично для других репозиториев
}