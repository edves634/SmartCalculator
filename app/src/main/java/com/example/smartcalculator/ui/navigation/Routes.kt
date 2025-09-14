package com.example.smartcalculator.ui.navigation

sealed class Routes(val route: String) {
    object Main : Routes("main")
    object Algebraic : Routes("algebraic")
    object Programmer : Routes("programmer")
    object Statistical : Routes("statistical")
    object Graphic : Routes("graphic")
    object Charts : Routes("charts")
    object QRGenerator : Routes("qr_generator")
    object History : Routes("history/{calculatorType}") {
        fun createRoute(calculatorType: String) = "history/$calculatorType"
    }
    object Help : Routes("help/{calculatorType}") {
        fun createRoute(calculatorType: String) = "help/$calculatorType"
    }
    object Settings : Routes("settings")
}