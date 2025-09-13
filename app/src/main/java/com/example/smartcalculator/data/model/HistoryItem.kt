package com.example.smartcalculator.data.model

data class HistoryItem(
    val id: Long,
    val calculatorType: CalculatorType,
    val expression: String,
    val result: String,
    val timestamp: Long
)