package com.example.smartcalculator.di

import android.content.Context
import com.example.smartcalculator.data.local.database.AppDatabase
import com.example.smartcalculator.data.local.database.dao.AlgebraicHistoryDao
import com.example.smartcalculator.data.local.database.dao.GraphicHistoryDao
import com.example.smartcalculator.data.local.database.dao.ProgrammerHistoryDao
import com.example.smartcalculator.data.local.database.dao.StatisticalHistoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideAlgebraicHistoryDao(appDatabase: AppDatabase): AlgebraicHistoryDao {
        return appDatabase.algebraicHistoryDao()
    }

    @Provides
    fun provideGraphicHistoryDao(appDatabase: AppDatabase): GraphicHistoryDao {
        return appDatabase.graphicHistoryDao()
    }

    @Provides
    fun provideProgrammerHistoryDao(appDatabase: AppDatabase): ProgrammerHistoryDao {
        return appDatabase.programmerHistoryDao()
    }

    @Provides
    fun provideStatisticalHistoryDao(appDatabase: AppDatabase): StatisticalHistoryDao {
        return appDatabase.statisticalHistoryDao()
    }
}