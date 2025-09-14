package com.example.smartcalculator.data.local.database.dao

import com.example.smartcalculator.data.local.database.entities.BaseHistoryEntity
import kotlinx.coroutines.flow.Flow

interface BaseHistoryDao<T : BaseHistoryEntity> {
    fun getAll(): Flow<List<T>>
    suspend fun insert(entity: T)
    suspend fun deleteAll()
    suspend fun deleteById(id: Long)
}