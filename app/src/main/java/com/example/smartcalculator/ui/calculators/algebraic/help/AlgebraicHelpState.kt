package com.example.smartcalculator.ui.calculators.algebraic.help

data class HelpItem(
    val title: String,
    val content: String
)

data class AlgebraicHelpState(
    val helpItems: List<HelpItem> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)