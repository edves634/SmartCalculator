package com.example.smartcalculator.data.repository

import com.example.smartcalculator.data.model.CalculatorType
import com.example.smartcalculator.data.model.HistoryItem
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {
    fun getHistory(calculatorType: CalculatorType? = null): Flow<List<HistoryItem>>
    suspend fun saveHistory(item: HistoryItem)
    suspend fun deleteHistory(item: HistoryItem)
    suspend fun clearHistory(calculatorType: CalculatorType? = null)
}