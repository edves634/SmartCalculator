package com.example.smartcalculator.di

import android.content.Context
import androidx.room.Room
import com.example.smartcalculator.data.local.database.AppDatabase
import com.example.smartcalculator.data.local.database.dao.AlgebraicHistoryDao
import com.example.smartcalculator.data.local.datastore.PreferencesManager
import com.example.smartcalculator.domain.util.ExpressionParser
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
            "calculator-db"
        ).build()
    }

    @Provides
    fun provideAlgebraicHistoryDao(db: AppDatabase): AlgebraicHistoryDao {
        return db.algebraicHistoryDao()
    }
    // Аналогично для других Dao
}