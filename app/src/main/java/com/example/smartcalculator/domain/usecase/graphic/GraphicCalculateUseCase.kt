
package com.example.smartcalculator.domain.usecase.graphic

import com.example.smartcalculator.domain.usecase.algebraic.CalculationException
import net.objecthunter.exp4j.ExpressionBuilder
import javax.inject.Inject

class GraphicCalculateUseCase @Inject constructor() {
    operator fun invoke(
        expression: String,
        xValues: DoubleArray
    ): Map<Double, Double> {
        return try {
            val result = mutableMapOf<Double, Double>()
            val expr = ExpressionBuilder(expression)
                .variable("x")
                .build()

            xValues.forEach { x ->
                expr.setVariable("x", x)
                result[x] = expr.evaluate()
            }

            result
        } catch (e: Exception) {
            throw CalculationException("Ошибка вычисления графика: ${e.message}")
        }
    }
}