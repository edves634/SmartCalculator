package com.example.smartcalculator.di

import com.example.smartcalculator.ui.calculators.algebraic.AlgebraicViewModel
import com.example.smartcalculator.ui.calculators.charts.ChartsViewModel
import com.example.smartcalculator.ui.calculators.graphic.GraphicViewModel
import com.example.smartcalculator.ui.calculators.programmer.ProgrammerViewModel
import com.example.smartcalculator.ui.calculators.qrgenerator.QRGeneratorViewModel
import com.example.smartcalculator.ui.calculators.statistical.StatisticalViewModel
import com.example.smartcalculator.ui.help.HelpViewModel
import com.example.smartcalculator.ui.history.HistoryViewModel
import com.example.smartcalculator.ui.main.MainViewModel
import com.example.smartcalculator.ui.settings.SettingsViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {

    @Binds
    @ViewModelScoped
    abstract fun bindAlgebraicViewModel(viewModel: AlgebraicViewModel): AlgebraicViewModel

    @Binds
    @ViewModelScoped
    abstract fun bindProgrammerViewModel(viewModel: ProgrammerViewModel): ProgrammerViewModel

    @Binds
    @ViewModelScoped
    abstract fun bindStatisticalViewModel(viewModel: StatisticalViewModel): StatisticalViewModel

    @Binds
    @ViewModelScoped
    abstract fun bindGraphicViewModel(viewModel: GraphicViewModel): GraphicViewModel

    @Binds
    @ViewModelScoped
    abstract fun bindChartsViewModel(viewModel: ChartsViewModel): ChartsViewModel

    @Binds
    @ViewModelScoped
    abstract fun bindQRGeneratorViewModel(viewModel: QRGeneratorViewModel): QRGeneratorViewModel

    @Binds
    @ViewModelScoped
    abstract fun bindHistoryViewModel(viewModel: HistoryViewModel): HistoryViewModel

    @Binds
    @ViewModelScoped
    abstract fun bindHelpViewModel(viewModel: HelpViewModel): HelpViewModel

    @Binds
    @ViewModelScoped
    abstract fun bindSettingsViewModel(viewModel: SettingsViewModel): SettingsViewModel

    @Binds
    @ViewModelScoped
    abstract fun bindMainViewModel(viewModel: MainViewModel): MainViewModel
}