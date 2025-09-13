package com.example.smartcalculator.di

import android.content.Context
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
    fun providePreferencesManager(@ApplicationContext context: Context): PreferencesManager {
        return PreferencesManager(context)
    }

    @Provides
    @Singleton
    fun provideConverters(): Converters {
        return Converters()
    }
}