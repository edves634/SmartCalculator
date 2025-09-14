package com.example.smartcalculator.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.smartcalculator.data.local.database.entities.StatisticalHistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StatisticalHistoryDao : BaseHistoryDao<StatisticalHistoryEntity> {
    @Query("SELECT * FROM algebraic_history ORDER BY timestamp DESC")
    override fun getAll(): Flow<List<StatisticalHistoryEntity>>

    @Insert
    override suspend fun insert(entity: StatisticalHistoryEntity)

    @Query("DELETE FROM Statistical_history")
    override suspend fun deleteAll()

    @Query("DELETE FROM Statistical_history WHERE id = :id")
    override suspend fun deleteById(id: Long)
}