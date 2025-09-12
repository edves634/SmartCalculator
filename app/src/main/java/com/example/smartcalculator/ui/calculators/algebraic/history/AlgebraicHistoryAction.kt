package com.example.smartcalculator.ui.calculators.algebraic.history

sealed class AlgebraicHistoryAction {
    object LoadHistory : AlgebraicHistoryAction()
    data class DeleteItem(val id: Long) : AlgebraicHistoryAction()
    object ClearAllHistory : AlgebraicHistoryAction()
}