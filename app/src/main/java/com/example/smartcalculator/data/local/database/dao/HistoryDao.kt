package com.example.smartcalculator.data.local.database.dao

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query
import com.example.smartcalculator.data.local.database.entities.BaseHistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Query("SELECT * FROM base_history ORDER BY timestamp DESC")
    fun getAllHistory(): Flow<List<BaseHistoryEntity>>
}
@Entity(tableName = "algebraic_history")
data class AlgebraicHistoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val expression: String,
    val result: String,
    val timestamp: Long
) : BaseHistoryEntity()