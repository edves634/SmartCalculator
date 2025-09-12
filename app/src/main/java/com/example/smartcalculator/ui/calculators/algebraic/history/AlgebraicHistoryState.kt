package com.example.smartcalculator.ui.calculators.algebraic.history

import com.example.smartcalculator.data.local.database.entities.AlgebraicHistoryEntity

data class AlgebraicHistoryState(
    val historyItems: List<AlgebraicHistoryEntity> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)