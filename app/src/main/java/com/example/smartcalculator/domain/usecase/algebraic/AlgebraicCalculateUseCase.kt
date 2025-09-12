package com.example.smartcalculator.domain.usecase.algebraic

import net.objecthunter.exp4j.ExpressionBuilder
import javax.inject.Inject

class AlgebraicCalculateUseCase @Inject constructor() {
    operator fun invoke(expression: String): Double {
        return try {
            // Заменяем символы на понятные exp4j
            val formattedExpression = expression
                .replace("×", "*")
                .replace("÷", "/")
                .replace("√", "sqrt")
                .replace("π", "pi")
                .replace("e", "E")

            ExpressionBuilder(formattedExpression)
                .build()
                .evaluate()
        } catch (e: Exception) {
            throw CalculationException("Ошибка вычисления выражения: ${e.message}")
        }
    }
}
class CalculationException(message: String) : Exception(message)

