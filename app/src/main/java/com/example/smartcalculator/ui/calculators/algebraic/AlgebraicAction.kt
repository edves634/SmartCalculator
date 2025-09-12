package com.example.smartcalculator.ui.calculators.algebraic

sealed class AlgebraicAction {
    data class Number(val number: Int) : AlgebraicAction()
    data class Operation(val operation: String) : AlgebraicAction()
    object Decimal : AlgebraicAction()
    object Calculate : AlgebraicAction()
    object Clear : AlgebraicAction()
    object Delete : AlgebraicAction()
    object ShowHistory : AlgebraicAction()
    object ShowHelp : AlgebraicAction()
}