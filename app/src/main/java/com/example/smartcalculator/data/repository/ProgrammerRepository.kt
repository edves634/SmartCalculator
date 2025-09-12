package com.example.smartcalculator.data.repository

import com.example.smartcalculator.data.local.database.entities.ProgrammerHistoryEntity
import kotlinx.coroutines.flow.Flow

interface ProgrammerRepository {
    fun getHistory(): Flow<List<ProgrammerHistoryEntity>>
    suspend fun insertHistory(entity: ProgrammerHistoryEntity)
    suspend fun deleteAllHistory()
    suspend fun deleteHistoryById(id: Long)
}