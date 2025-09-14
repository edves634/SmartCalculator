package com.example.smartcalculator.data.local.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "algebraic_history")
data class AlgebraicHistoryEntity(
    @PrimaryKey(autoGenerate = true)
    override val id: Long = 0,
    override val expression: String,
    override val result: String,
    override val timestamp: Long = System.currentTimeMillis()
) : BaseHistoryEntity()