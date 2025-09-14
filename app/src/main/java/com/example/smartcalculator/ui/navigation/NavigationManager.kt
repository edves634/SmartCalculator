package com.example.smartcalculator.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder

class NavigationManager {
    private var navController: NavController? = null

    fun setNavController(navController: NavController) {
        this.navController = navController
    }

    fun navigateTo(
        route: String,
        builder: (NavOptionsBuilder.() -> Unit)? = null
    ) {
        if (builder != null) {
            navController?.navigate(route, builder)
        } else {
            navController?.navigate(route)
        }
    }

    fun navigateToAlgebraic(builder: (NavOptionsBuilder.() -> Unit)? = null) {
        navigateTo(Routes.Algebraic.route, builder)
    }

    fun navigateToGraphic(builder: (NavOptionsBuilder.() -> Unit)? = null) {
        navigateTo(Routes.Graphic.route, builder)
    }

    fun navigateToStatistical(builder: (NavOptionsBuilder.() -> Unit)? = null) {
        navigateTo(Routes.Statistical.route, builder)
    }

    fun navigateToProgrammer(builder: (NavOptionsBuilder.() -> Unit)? = null) {
        navigateTo(Routes.Programmer.route, builder)
    }

    fun navigateToCharts(builder: (NavOptionsBuilder.() -> Unit)? = null) {
        navigateTo(Routes.Charts.route, builder)
    }

    fun navigateToQRGenerator(builder: (NavOptionsBuilder.() -> Unit)? = null) {
        navigateTo(Routes.QRGenerator.route, builder)
    }

    fun navigateToHistory(calculatorType: String, builder: (NavOptionsBuilder.() -> Unit)? = null) {
        navigateTo(Routes.History.createRoute(calculatorType), builder)
    }

    fun navigateToHelp(calculatorType: String, builder: (NavOptionsBuilder.() -> Unit)? = null) {
        navigateTo(Routes.Help.createRoute(calculatorType), builder)
    }

    fun navigateToSettings(builder: (NavOptionsBuilder.() -> Unit)? = null) {
        navigateTo(Routes.Settings.route, builder)
    }

    fun navigateToMain(builder: (NavOptionsBuilder.() -> Unit)? = null) {
        navigateTo(Routes.Main.route, builder)
    }

    fun goBack() {
        navController?.popBackStack()
    }

    fun clearBackStack(route: String, inclusive: Boolean = false) {
        navController?.popBackStack(route, inclusive)
    }

    fun getCurrentRoute(): String? {
        return navController?.currentBackStackEntry?.destination?.route
    }
}