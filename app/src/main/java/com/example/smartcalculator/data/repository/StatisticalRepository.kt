package com.example.smartcalculator.data.repository

import com.example.smartcalculator.data.local.database.entities.StatisticalHistoryEntity
import kotlinx.coroutines.flow.Flow

interface StatisticalRepository {
    fun getHistory(): Flow<List<StatisticalHistoryEntity>>
    suspend fun insertHistory(entity: StatisticalHistoryEntity)
    suspend fun deleteAllHistory()
    suspend fun deleteHistoryById(id: Long)
}