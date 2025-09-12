package com.example.smartcalculator.ui.calculators.algebraic

data class AlgebraicUiState(
    val input: String = "",
    val result: String = "",
    val error: String? = null
)