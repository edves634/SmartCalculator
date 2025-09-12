package com.example.smartcalculator.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.smartcalculator.data.local.database.entities.GraphicHistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GraphicHistoryDao {
    @Query("SELECT * FROM graphic_history ORDER BY timestamp DESC")
    fun getAll(): Flow<List<GraphicHistoryEntity>>

    @Insert
    suspend fun insert(entity: GraphicHistoryEntity)

    @Query("DELETE FROM graphic_history")
    suspend fun deleteAll()

    @Query("DELETE FROM graphic_history WHERE id = :id")
    suspend fun deleteById(id: Long)
}
