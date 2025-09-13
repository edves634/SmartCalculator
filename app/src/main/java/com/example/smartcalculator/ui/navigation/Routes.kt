package com.example.smartcalculator.ui.navigation

sealed class Routes(val route: String) {
    object Main : Routes("main")
    object Algebraic : Routes("algebraic")
    object Programmer : Routes("programmer")
    object Graphic : Routes("graphic")
    object Statistical : Routes("statistical")
    object Charts : Routes("charts")
    object QRGenerator : Routes("qr_generator")
    object History : Routes("history")
    object Help : Routes("help")
    object Settings : Routes("settings")

    // Вложенные маршруты для алгебраического калькулятора
    object AlgebraicHistory : Routes("algebraic/history")
    object AlgebraicHelp : Routes("algebraic/help")
}