package com.example.smartcalculator.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.smartcalculator.data.local.database.entities.ProgrammerHistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProgrammerHistoryDao : BaseHistoryDao<ProgrammerHistoryEntity> {
    @Query("SELECT * FROM algebraic_history ORDER BY timestamp DESC")
    override fun getAll(): Flow<List<ProgrammerHistoryEntity>>

    @Insert
    override suspend fun insert(entity: ProgrammerHistoryEntity)

    @Query("DELETE FROM Programmer_history")
    override suspend fun deleteAll()

    @Query("DELETE FROM Programmer_history WHERE id = :id")
    override suspend fun deleteById(id: Long)
}