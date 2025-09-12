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
        navigateTo(Routes.ALGEBRAIC, builder)
    }

    fun navigateToGraphic(builder: (NavOptionsBuilder.() -> Unit)? = null) {
        navigateTo(Routes.GRAPHIC, builder)
    }

    fun navigateToStatistical(builder: (NavOptionsBuilder.() -> Unit)? = null) {
        navigateTo(Routes.STATISTICAL, builder)
    }

    fun navigateToProgrammer(builder: (NavOptionsBuilder.() -> Unit)? = null) {
        navigateTo(Routes.PROGRAMMER, builder)
    }

    fun navigateToCharts(builder: (NavOptionsBuilder.() -> Unit)? = null) {
        navigateTo(Routes.CHARTS, builder)
    }

    fun navigateToQRGenerator(builder: (NavOptionsBuilder.() -> Unit)? = null) {
        navigateTo(Routes.QR_GENERATOR, builder)
    }

    fun navigateToHistory(builder: (NavOptionsBuilder.() -> Unit)? = null) {
        navigateTo(Routes.ALGEBRAIC_HISTORY, builder)
    }

    fun navigateToHelp(builder: (NavOptionsBuilder.() -> Unit)? = null) {
        navigateTo(Routes.ALGEBRAIC_HELP, builder)
    }

    fun navigateToSettings(builder: (NavOptionsBuilder.() -> Unit)? = null) {
        navigateTo(Routes.SETTINGS, builder)
    }

    fun navigateToHome(builder: (NavOptionsBuilder.() -> Unit)? = null) {
        navigateTo(Routes.HOME, builder)
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