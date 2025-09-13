package com.example.smartcalculator.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.smartcalculator.ui.calculators.algebraic.AlgebraicScreen
import com.example.smartcalculator.ui.calculators.algebraic.AlgebraicViewModel
import com.example.smartcalculator.ui.calculators.charts.ChartsScreen
import com.example.smartcalculator.ui.calculators.charts.ChartsViewModel
import com.example.smartcalculator.ui.calculators.graphic.GraphicScreen
import com.example.smartcalculator.ui.calculators.graphic.GraphicViewModel
import com.example.smartcalculator.ui.calculators.programmer.ProgrammerScreen
import com.example.smartcalculator.ui.calculators.programmer.ProgrammerViewModel
import com.example.smartcalculator.ui.calculators.qrgenerator.QRGeneratorScreen
import com.example.smartcalculator.ui.calculators.qrgenerator.QRGeneratorViewModel
import com.example.smartcalculator.ui.calculators.statistical.StatisticalScreen
import com.example.smartcalculator.ui.calculators.statistical.StatisticalViewModel
import com.example.smartcalculator.ui.help.HelpScreen
import com.example.smartcalculator.ui.help.HelpViewModel
import com.example.smartcalculator.ui.history.HistoryScreen
import com.example.smartcalculator.ui.history.HistoryViewModel
import com.example.smartcalculator.ui.main.MainScreen
import com.example.smartcalculator.ui.main.MainViewModel
import com.example.smartcalculator.ui.settings.SettingsScreen
import com.example.smartcalculator.ui.settings.SettingsViewModel

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.Main.route
    ) {
        composable(Routes.Main.route) {
            val viewModel = hiltViewModel<MainViewModel>()
            MainScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(Routes.Algebraic.route) {
            val viewModel = hiltViewModel<AlgebraicViewModel>()
            AlgebraicScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(Routes.Programmer.route) {
            val viewModel = hiltViewModel<ProgrammerViewModel>()
            ProgrammerScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(Routes.Graphic.route) {
            val viewModel = hiltViewModel<GraphicViewModel>()
            GraphicScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(Routes.Statistical.route) {
            val viewModel = hiltViewModel<StatisticalViewModel>()
            StatisticalScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(Routes.Charts.route) {
            val viewModel = hiltViewModel<ChartsViewModel>()
            ChartsScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(Routes.QRGenerator.route) {
            val viewModel = hiltViewModel<QRGeneratorViewModel>()
            QRGeneratorScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(Routes.History.route) {
            val viewModel = hiltViewModel<HistoryViewModel>()
            val historyState by viewModel.historyState.collectAsState()

            HistoryScreen(
                navController = navController,
                historyState = historyState,
                onDeleteAll = viewModel::deleteAllHistory,
                onDeleteItem = viewModel::deleteHistoryItem
            )
        }

        composable(Routes.Help.route) {
            val viewModel = hiltViewModel<HelpViewModel>()
            val helpItems by viewModel.helpItems.collectAsState()

            HelpScreen(
                navController = navController,
                helpItems = helpItems
            )
        }

        composable(Routes.Settings.route) {
            val viewModel = hiltViewModel<SettingsViewModel>()
            val uiState by viewModel.uiState.collectAsState()

            SettingsScreen(
                navController = navController,
                uiState = uiState,
                onThemeChange = viewModel::setThemePreference
            )
        }

        // Вложенная навигация для алгебраического калькулятора
        composable(Routes.AlgebraicHistory.route) {
            val viewModel = hiltViewModel<AlgebraicViewModel>()
            // Здесь должна быть реализация экрана истории алгебраических вычислений
        }

        composable(Routes.AlgebraicHelp.route) {
            // Здесь должна быть реализация экрана помощи для алгебраического калькулятора
        }
    }
}