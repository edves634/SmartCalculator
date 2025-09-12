package com.example.smartcalculator.data.repository

import com.example.smartcalculator.data.local.database.entities.GraphicHistoryEntity
import kotlinx.coroutines.flow.Flow

interface GraphicRepository {
    fun getHistory(): Flow<List<GraphicHistoryEntity>>
    suspend fun insertHistory(entity: GraphicHistoryEntity)
    suspend fun deleteAllHistory()
    suspend fun deleteHistoryById(id: Long)
}