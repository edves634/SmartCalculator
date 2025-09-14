package com.example.smartcalculator.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.smartcalculator.data.local.database.entities.GraphicHistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GraphicHistoryDao : BaseHistoryDao<GraphicHistoryEntity> {
    @Query("SELECT * FROM algebraic_history ORDER BY timestamp DESC")
    override fun getAll(): Flow<List<GraphicHistoryEntity>>

    @Insert
    override suspend fun insert(entity: GraphicHistoryEntity)

    @Query("DELETE FROM Graphic_history")
    override suspend fun deleteAll()

    @Query("DELETE FROM Graphic_history WHERE id = :id")
    override suspend fun deleteById(id: Long)
}
