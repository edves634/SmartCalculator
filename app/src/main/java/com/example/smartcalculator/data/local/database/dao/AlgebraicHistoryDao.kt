package com.example.smartcalculator.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.smartcalculator.data.local.database.entities.AlgebraicHistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AlgebraicHistoryDao {
    @Query("SELECT * FROM algebraic_history ORDER BY timestamp DESC")
    fun getAll(): Flow<List<AlgebraicHistoryEntity>>

    @Insert
    suspend fun insert(entity: AlgebraicHistoryEntity)

    @Query("DELETE FROM algebraic_history")
    suspend fun deleteAll()

    @Query("DELETE FROM algebraic_history WHERE id = :id")
    suspend fun deleteById(id: Long?)
}