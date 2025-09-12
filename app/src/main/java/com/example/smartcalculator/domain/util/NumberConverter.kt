package com.example.smartcalculator.domain.util

import javax.inject.Inject

class NumberConverter @Inject constructor() {
    fun convert(value: String, fromBase: Int, toBase: Int): String {
        val decimal = toDecimal(value, fromBase)
        return fromDecimal(decimal, toBase)
    }

    fun toDecimal(value: String, fromBase: Int): Int {
        return when (fromBase) {
            2 -> value.toInt(2)
            8 -> value.toInt(8)
            10 -> value.toInt()
            16 -> value.toInt(16)
            else -> throw IllegalArgumentException("Unsupported base: $fromBase")
        }
    }

    fun fromDecimal(value: Int, toBase: Int): String {
        return when (toBase) {
            2 -> Integer.toBinaryString(value)
            8 -> Integer.toOctalString(value)
            10 -> value.toString()
            16 -> Integer.toHexString(value).uppercase()
            else -> throw IllegalArgumentException("Unsupported base: $toBase")
        }
    }
}