package com.example.smartcalculator.data.local.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "graphic_history")
data class GraphicHistoryEntity(
    @PrimaryKey(autoGenerate = true)
    override var id: Long = 0,
    override var expression: String = "",
    override var result: String = "",
    override var timestamp: Long = System.currentTimeMillis()
) : BaseHistoryEntity()