package com.example.smartcalculator.di

import com.example.smartcalculator.domain.usecase.algebraic.AlgebraicCalculateUseCase
import com.example.smartcalculator.domain.usecase.graphic.GraphicCalculateUseCase
import com.example.smartcalculator.domain.usecase.programmer.ProgrammerCalculateUseCase
import com.example.smartcalculator.domain.usecase.statistical.StatisticalCalculateUseCase
import com.example.smartcalculator.domain.util.NumberConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {
    @Provides
    fun provideAlgebraicCalculateUseCase(): AlgebraicCalculateUseCase {
        return AlgebraicCalculateUseCase()
    }

    @Provides
    fun provideGraphicCalculateUseCase(): GraphicCalculateUseCase {
        return GraphicCalculateUseCase()
    }

    @Provides
    fun provideProgrammerCalculateUseCase(
        numberConverter: NumberConverter
    ): ProgrammerCalculateUseCase {
        return ProgrammerCalculateUseCase(numberConverter)
    }

    @Provides
    fun provideStatisticalCalculateUseCase(): StatisticalCalculateUseCase {
        return StatisticalCalculateUseCase()
    }

    @Provides
    fun provideNumberConverter(): NumberConverter {
        return NumberConverter()
    }
}