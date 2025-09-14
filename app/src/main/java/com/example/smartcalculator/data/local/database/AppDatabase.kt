package com.example.smartcalculator.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.smartcalculator.data.local.database.dao.AlgebraicHistoryDao
import com.example.smartcalculator.data.local.database.dao.GraphicHistoryDao
import com.example.smartcalculator.data.local.database.dao.ProgrammerHistoryDao
import com.example.smartcalculator.data.local.database.dao.StatisticalHistoryDao
import com.example.smartcalculator.data.local.database.entities.AlgebraicHistoryEntity
import com.example.smartcalculator.data.local.database.entities.GraphicHistoryEntity
import com.example.smartcalculator.data.local.database.entities.ProgrammerHistoryEntity
import com.example.smartcalculator.data.local.database.entities.StatisticalHistoryEntity

@Database(
    entities = [
        AlgebraicHistoryEntity::class,
        ProgrammerHistoryEntity::class,
        StatisticalHistoryEntity::class,
        GraphicHistoryEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun algebraicHistoryDao(): AlgebraicHistoryDao
    abstract fun programmerHistoryDao(): ProgrammerHistoryDao
    abstract fun statisticalHistoryDao(): StatisticalHistoryDao
    abstract fun graphicHistoryDao(): GraphicHistoryDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "smart-calculator-db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}