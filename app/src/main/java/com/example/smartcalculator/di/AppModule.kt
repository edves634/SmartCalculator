package com.example.smartcalculator.di

import com.example.smartcalculator.domain.util.ExpressionParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideExpressionParser(): ExpressionParser = ExpressionParser
}