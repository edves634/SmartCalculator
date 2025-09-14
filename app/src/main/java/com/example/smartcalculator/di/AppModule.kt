package com.example.smartcalculator.di

import android.content.Context
import androidx.room.Room
import com.example.smartcalculator.data.local.database.AppDatabase
import com.example.smartcalculator.data.local.datastore.PreferencesManager
import com.example.smartcalculator.data.repository.AlgebraicRepositoryImpl
import com.example.smartcalculator.data.repository.HelpRepositoryImpl
import com.example.smartcalculator.data.repository.HistoryRepositoryImpl
import com.example.smartcalculator.data.repository.SettingsRepositoryImpl
import com.example.smartcalculator.data.repository.AlgebraicRepository
import com.example.smartcalculator.data.repository.HelpRepository
import com.example.smartcalculator.data.repository.HistoryRepository
import com.example.smartcalculator.data.repository.SettingsRepository
import com.example.smartcalculator.util.Converters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "smart-calculator-db"
        ).build()
    }

    @Provides
    @Singleton
    fun providePreferencesManager(@ApplicationContext context: Context): PreferencesManager {
        return PreferencesManager(context)
    }

    @Provides
    @Singleton
    fun provideConverters(): Converters {
        return Converters()
    }

    @Provides
    @Singleton
    fun provideHistoryRepository(
        database: AppDatabase,
        converters: Converters
    ): HistoryRepository {
        return HistoryRepositoryImpl(
            algebraicDao = database.algebraicHistoryDao(),
            graphicDao = database.graphicHistoryDao(),
            programmerDao = database.programmerHistoryDao(),
            statisticalDao = database.statisticalHistoryDao(),
            converters = converters
        )
    }

    @Provides
    @Singleton
    fun provideAlgebraicRepository(database: AppDatabase): AlgebraicRepository {
        return AlgebraicRepositoryImpl(dao = database.algebraicHistoryDao())
    }

    @Provides
    @Singleton
    fun provideHelpRepository(): HelpRepository {
        return HelpRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideSettingsRepository(preferencesManager: PreferencesManager): SettingsRepository {
        return SettingsRepositoryImpl(preferencesManager = preferencesManager)
    }
}