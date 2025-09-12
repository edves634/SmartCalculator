package com.example.smartcalculator.data.repository


import com.example.smartcalculator.data.local.database.entities.AlgebraicHistoryEntity
import kotlinx.coroutines.flow.Flow


interface AlgebraicRepository {
    fun getHistory(): Flow<List<AlgebraicHistoryEntity>>
    suspend fun insertHistory(entity: AlgebraicHistoryEntity)
    suspend fun deleteAllHistory()
    suspend fun deleteHistoryById(id: Long?)
}