package com.example.smartcalculator.di

import com.example.smartcalculator.data.repository.AlgebraicRepository
import com.example.smartcalculator.data.repository.AlgebraicRepositoryImpl
import com.example.smartcalculator.data.repository.GraphicRepository
import com.example.smartcalculator.data.repository.GraphicRepositoryImpl
import com.example.smartcalculator.data.repository.ProgrammerRepository
import com.example.smartcalculator.data.repository.ProgrammerRepositoryImpl
import com.example.smartcalculator.data.repository.SettingsRepository
import com.example.smartcalculator.data.repository.SettingsRepositoryImpl
import com.example.smartcalculator.data.repository.StatisticalRepository
import com.example.smartcalculator.data.repository.StatisticalRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindAlgebraicRepository(
        algebraicRepositoryImpl: AlgebraicRepositoryImpl
    ): AlgebraicRepository

    @Binds
    abstract fun bindGraphicRepository(
        graphicRepositoryImpl: GraphicRepositoryImpl
    ): GraphicRepository

    @Binds
    abstract fun bindProgrammerRepository(
        programmerRepositoryImpl: ProgrammerRepositoryImpl
    ): ProgrammerRepository

    @Binds
    abstract fun bindStatisticalRepository(
        statisticalRepositoryImpl: StatisticalRepositoryImpl
    ): StatisticalRepository

    @Binds
    abstract fun bindSettingsRepository(
        settingsRepositoryImpl: SettingsRepositoryImpl
    ): SettingsRepository
}