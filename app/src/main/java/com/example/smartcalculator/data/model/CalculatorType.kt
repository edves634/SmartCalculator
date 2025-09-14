package com.example.smartcalculator.data.model

enum class CalculatorType(
    val title: String,
    val description: String,
    val routeName: String,
    val hasHistory: Boolean = true
) {
    ALGEBRAIC(
        title = "Algebraic",
        description = "Standard calculator with basic operations",
        routeName = "algebraic"
    ),
    PROGRAMMER(
        title = "Programmer",
        description = "Calculator for programmers with bit operations",
        routeName = "programmer"
    ),
    STATISTICAL(
        title = "Statistical",
        description = "Calculator for statistical calculations",
        routeName = "statistical"
    ),
    GRAPHIC(
        title = "Graphic",
        description = "Function graphing calculator",
        routeName = "graphic"
    ),
    CHARTS(
        title = "Charts",
        description = "Data visualization with charts",
        routeName = "charts",
        hasHistory = false
    ),
    QR_GENERATOR(
        title = "QR Generator",
        description = "Generate QR codes from text",
        routeName = "qr_generator",
        hasHistory = false
    )
}