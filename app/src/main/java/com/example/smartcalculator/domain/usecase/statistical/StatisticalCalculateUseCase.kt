package com.example.smartcalculator.domain.usecase.statistical

import com.example.smartcalculator.domain.usecase.algebraic.CalculationException
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics
import org.apache.commons.math3.stat.descriptive.rank.Percentile
import javax.inject.Inject

class StatisticalCalculateUseCase @Inject constructor() {
    operator fun invoke(values: DoubleArray): StatisticalResult {
        return try {
            val stats = DescriptiveStatistics(values)
            val percentile = Percentile().apply {
                setData(values)
            }

            StatisticalResult(
                mean = stats.mean,
                median = percentile.evaluate(50.0),
                mode = calculateMode(values),
                min = stats.min,
                max = stats.max,
                range = stats.max - stats.min,
                variance = stats.variance,
                standardDeviation = stats.standardDeviation
            )
        } catch (e: Exception) {
            throw CalculationException("Ошибка статистических вычислений: ${e.message}")
        }
    }

    private fun calculateMode(values: DoubleArray): Double {
        if (values.isEmpty()) return 0.0

        val frequencyMap = mutableMapOf<Double, Int>()
        values.forEach { value ->
            frequencyMap[value] = frequencyMap.getOrDefault(value, 0) + 1
        }

        val maxFrequency = frequencyMap.values.maxOrNull() ?: 0
        return frequencyMap.entries
            .firstOrNull { it.value == maxFrequency }
            ?.key ?: values.first()
    }
}

data class StatisticalResult(
    val mean: Double,
    val median: Double,
    val mode: Double,
    val min: Double,
    val max: Double,
    val range: Double,
    val variance: Double,
    val standardDeviation: Double
)