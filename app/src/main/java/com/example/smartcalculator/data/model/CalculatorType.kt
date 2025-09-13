package com.example.smartcalculator.data.model

enum class CalculatorType {
    ALGEBRAIC, GRAPHIC, PROGRAMMER, STATISTICAL, CHARTS, GENERATOR
}
data class HistoryItem(
    val id: Long,
    val calculatorType: CalculatorType,
    val expression: String,
    val result: String,
    val timestamp: Long
)