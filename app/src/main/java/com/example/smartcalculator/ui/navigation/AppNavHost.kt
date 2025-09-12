package com.example.smartcalculator.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smartcalculator.ui.calculators.algebraic.AlgebraicScreen
import com.example.smartcalculator.ui.calculators.algebraic.help.AlgebraicHelpScreen
import com.example.smartcalculator.ui.calculators.algebraic.history.AlgebraicHistoryScreen
import com.example.smartcalculator.ui.calculators.charts.ChartsScreen
import com.example.smartcalculator.ui.calculators.graphic.GraphicScreen
import com.example.smartcalculator.ui.calculators.programmer.ProgrammerScreen
import com.example.smartcalculator.ui.calculators.qrgenerator.QRGeneratorScreen
import com.example.smartcalculator.ui.calculators.statistical.StatisticalScreen
import com.example.smartcalculator.ui.main.MainScreen
import com.example.smartcalculator.ui.main.MainViewModel
import com.example.smartcalculator.ui.settings.SettingsScreen
import com.example.smartcalculator.ui.settings.SettingsViewModel

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    val mainViewModel = hiltViewModel<MainViewModel>()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            MainScreen(navController = navController)
        }

        composable(Routes.ALGEBRAIC) {
            AlgebraicScreen(navController = navController)
        }
        composable(Routes.GRAPHIC) {
            GraphicScreen(navController = navController)
        }
        composable(Routes.STATISTICAL) {
            StatisticalScreen(navController = navController)
        }
        composable(Routes.PROGRAMMER) {
            ProgrammerScreen(navController = navController)
        }
        composable(Routes.CHARTS) {
            ChartsScreen(navController = navController)
        }
        composable(Routes.QR_GENERATOR) {
            QRGeneratorScreen(navController = navController)
        }

        // Удаляем дубликат композируемой функции для Routes.ALGEBRAIC

        // Исправляем передачу параметров для этих экранов
        composable("${Routes.ALGEBRAIC}/history") {
            AlgebraicHistoryScreen(navController = navController)
        }
        composable("${Routes.ALGEBRAIC}/help") {
            AlgebraicHelpScreen(navController = navController)
        }

        composable(Routes.SETTINGS) {
            val viewModel = hiltViewModel<SettingsViewModel>()
            val uiState by viewModel.uiState.collectAsState()

            SettingsScreen(
                navController = navController,
                uiState = uiState,
                onThemeChange = viewModel::setThemePreference
            )
        }
    }
}