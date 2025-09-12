package com.example.smartcalculator.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.smartcalculator.data.local.database.entities.ProgrammerHistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProgrammerHistoryDao {
    @Query("SELECT * FROM programmer_history ORDER BY timestamp DESC")
    fun getAll(): Flow<List<ProgrammerHistoryEntity>>

    @Insert
    suspend fun insert(entity: ProgrammerHistoryEntity)

    @Query("DELETE FROM programmer_history")
    suspend fun deleteAll()

    @Query("DELETE FROM programmer_history WHERE id = :id")
    suspend fun deleteById(id: Long)
}