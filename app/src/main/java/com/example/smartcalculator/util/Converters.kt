package com.example.smartcalculator.util

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromDoubleList(value: List<Double>): String {
        return value.joinToString(",")
    }

    @TypeConverter
    fun toDoubleList(value: String): List<Double> {
        return if (value.isEmpty()) emptyList()
        else value.split(",").map { it.toDouble() }
    }

    @TypeConverter
    fun fromMap(value: Map<String, String>): String {
        return value.entries.joinToString(";") { "${it.key}:${it.value}" }
    }

    @TypeConverter
    fun toMap(value: String): Map<String, String> {
        return if (value.isEmpty()) emptyMap()
        else value.split(";").associate {
            val (key, value) = it.split(":")
            key to value
        }
    }
}