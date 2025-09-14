package com.example.smartcalculator.data.repository

import com.example.smartcalculator.data.local.database.entities.AlgebraicHistoryEntity
import kotlinx.coroutines.flow.Flow

interface AlgebraicRepository {
    suspend fun saveHistory(item: AlgebraicHistoryEntity)
    fun getHistory(): Flow<List<AlgebraicHistoryEntity>>
}