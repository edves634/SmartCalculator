package com.example.smartcalculator.di

import androidx.lifecycle.ViewModel
import com.example.smartcalculator.domain.usecase.algebraic.AlgebraicCalculateUseCase
import com.example.smartcalculator.domain.usecase.graphic.GraphicCalculateUseCase
import com.example.smartcalculator.domain.usecase.programmer.ProgrammerCalculateUseCase
import com.example.smartcalculator.domain.usecase.statistical.StatisticalCalculateUseCase
import com.example.smartcalculator.domain.util.NumberConverter
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
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HistoryViewModel::class)
    abstract fun bindHistoryViewModel(viewModel: HistoryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HelpViewModel::class)
    abstract fun bindHelpViewModel(viewModel: HelpViewModel): ViewModel

    // Аналогично для других ViewModel
}