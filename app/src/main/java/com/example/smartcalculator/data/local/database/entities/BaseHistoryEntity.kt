package com.example.smartcalculator.data.local.database.entities

open class BaseHistoryEntity {
    open val id: Long = 0
    open val expression: String = ""
    open val result: String = ""
    open val timestamp: Long = System.currentTimeMillis()
}

