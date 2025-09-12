package com.example.smartcalculator.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.smartcalculator.data.local.database.entities.StatisticalHistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StatisticalHistoryDao {
    @Query("SELECT * FROM statistical_history ORDER BY timestamp DESC")
    fun getAll(): Flow<List<StatisticalHistoryEntity>>

    @Insert
    suspend fun insert(entity: StatisticalHistoryEntity)

    @Query("DELETE FROM statistical_history")
    suspend fun deleteAll()

    @Query("DELETE FROM statistical_history WHERE id = :id")
    suspend fun deleteById(id: Long)
}