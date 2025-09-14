package com.example.smartcalculator.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smartcalculator.ui.calculators.algebraic.AlgebraicScreen
import com.example.smartcalculator.ui.calculators.charts.ChartsScreen
import com.example.smartcalculator.ui.calculators.graphic.GraphicScreen
import com.example.smartcalculator.ui.calculators.programmer.ProgrammerScreen
import com.example.smartcalculator.ui.calculators.qrgenerator.QRGeneratorScreen
import com.example.smartcalculator.ui.calculators.statistical.StatisticalScreen
import com.example.smartcalculator.ui.help.HelpScreen
import com.example.smartcalculator.ui.history.HistoryScreen
import com.example.smartcalculator.ui.main.MainScreen
import com.example.smartcalculator.ui.settings.SettingsScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Main.route
    ) {
        composable(Routes.Main.route) {
            MainScreen(
                onNavigate = { route ->
                    when (route) {
                        "algebraic" -> navController.navigate(Routes.Algebraic.route)
                        "programmer" -> navController.navigate(Routes.Programmer.route)
                        "statistical" -> navController.navigate(Routes.Statistical.route)
                        "graphic" -> navController.navigate(Routes.Graphic.route)
                        "charts" -> navController.navigate(Routes.Charts.route)
                        "qr_generator" -> navController.navigate(Routes.QRGenerator.route)
                        "settings" -> navController.navigate(Routes.Settings.route)
                    }
                }
            )
        }

        composable(Routes.Algebraic.route) {
            AlgebraicScreen(
                onNavigate = { route ->
                    when {
                        route.startsWith("history") -> navController.navigate(Routes.History.createRoute("algebraic"))
                        route.startsWith("help") -> navController.navigate(Routes.Help.createRoute("algebraic"))
                        else -> navController.popBackStack()
                    }
                }
            )
        }

        composable(Routes.Programmer.route) {
            ProgrammerScreen(
                onNavigate = { route ->
                    when {
                        route.startsWith("history") -> navController.navigate(Routes.History.createRoute("programmer"))
                        route.startsWith("help") -> navController.navigate(Routes.Help.createRoute("programmer"))
                        else -> navController.popBackStack()
                    }
                }
            )
        }

        composable(Routes.Statistical.route) {
            StatisticalScreen(
                onNavigate = { route ->
                    when {
                        route.startsWith("history") -> navController.navigate(Routes.History.createRoute("statistical"))
                        route.startsWith("help") -> navController.navigate(Routes.Help.createRoute("statistical"))
                        else -> navController.popBackStack()
                    }
                }
            )
        }

        composable(Routes.Graphic.route) {
            GraphicScreen(
                onNavigate = { route ->
                    when {
                        route.startsWith("history") -> navController.navigate(Routes.History.createRoute("graphic"))
                        route.startsWith("help") -> navController.navigate(Routes.Help.createRoute("graphic"))
                        else -> navController.popBackStack()
                    }
                }
            )
        }

        composable(Routes.Charts.route) {
            ChartsScreen(
                onNavigate = { navController.popBackStack() }
            )
        }

        composable(Routes.QRGenerator.route) {
            QRGeneratorScreen(
                onNavigate = { navController.popBackStack() }
            )
        }

        composable(Routes.History.route) { backStackEntry ->
            val calculatorType = backStackEntry.arguments?.getString("calculatorType") ?: "algebraic"
            HistoryScreen(
                calculatorType = calculatorType,
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.Help.route) { backStackEntry ->
            val calculatorType = backStackEntry.arguments?.getString("calculatorType") ?: "algebraic"
            HelpScreen(
                calculatorType = calculatorType,
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.Settings.route) {
            SettingsScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}