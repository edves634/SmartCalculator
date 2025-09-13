package com.example.smartcalculator.di

import androidx.lifecycle.ViewModel
import com.example.smartcalculator.data.repository.AlgebraicRepository
import com.example.smartcalculator.domain.usecase.algebraic.AlgebraicCalculateUseCase
import com.example.smartcalculator.domain.usecase.graphic.GraphicCalculateUseCase
import com.example.smartcalculator.domain.usecase.programmer.ProgrammerCalculateUseCase
import com.example.smartcalculator.domain.usecase.statistical.StatisticalCalculateUseCase
import com.example.smartcalculator.domain.util.NumberConverter
import com.example.smartcalculator.ui.calculators.algebraic.AlgebraicViewModel
import com.example.smartcalculator.ui.help.HelpViewModel
import com.example.smartcalculator.ui.history.HistoryViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {
    @Provides
    fun provideAlgebraicViewModel(
        repository: AlgebraicRepository,
        calculateUseCase: AlgebraicCalculateUseCase
    ): AlgebraicViewModel {
        return AlgebraicViewModel(repository, calculateUseCase)
    }

    // Аналогично для других ViewModel
}