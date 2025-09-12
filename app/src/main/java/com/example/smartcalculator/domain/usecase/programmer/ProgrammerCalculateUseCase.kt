
package com.example.smartcalculator.domain.usecase.programmer

import com.example.smartcalculator.domain.usecase.algebraic.CalculationException
import com.example.smartcalculator.domain.util.NumberConverter
import javax.inject.Inject

class ProgrammerCalculateUseCase @Inject constructor(
    private val numberConverter: NumberConverter
) {
    operator fun invoke(
        value: String,
        fromBase: Int,
        toBase: Int,
        operation: String? = null,
        secondValue: String? = null
    ): String {
        return try {
            when (operation) {
                "AND" -> performBitwiseOperation(value, secondValue!!, fromBase) { a, b -> a and b }
                "OR" -> performBitwiseOperation(value, secondValue!!, fromBase) { a, b -> a or b }
                "XOR" -> performBitwiseOperation(value, secondValue!!, fromBase) { a, b -> a xor b }
                "NOT" -> performNotOperation(value, fromBase)
                "<<" -> performShiftOperation(value, secondValue!!, fromBase) { a, b -> a shl b }
                ">>" -> performShiftOperation(value, secondValue!!, fromBase) { a, b -> a shr b }
                else -> numberConverter.convert(value, fromBase, toBase)
            }
        } catch (e: Exception) {
            throw CalculationException("Ошибка преобразования: ${e.message}")
        }
    }

    private fun performBitwiseOperation(
        first: String,
        second: String,
        base: Int,
        operation: (Int, Int) -> Int
    ): String {
        val firstInt = numberConverter.toDecimal(first, base)
        val secondInt = numberConverter.toDecimal(second, base)
        val result = operation(firstInt, secondInt)
        return numberConverter.fromDecimal(result, base)
    }

    private fun performNotOperation(value: String, base: Int): String {
        val intValue = numberConverter.toDecimal(value, base)
        val result = intValue.inv()
        return numberConverter.fromDecimal(result, base)
    }

    private fun performShiftOperation(
        value: String,
        shift: String,
        base: Int,
        operation: (Int, Int) -> Int
    ): String {
        val intValue = numberConverter.toDecimal(value, base)
        val shiftAmount = shift.toInt()
        val result = operation(intValue, shiftAmount)
        return numberConverter.fromDecimal(result, base)
    }
}