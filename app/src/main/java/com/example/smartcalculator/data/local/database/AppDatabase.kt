package com.example.smartcalculator.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.smartcalculator.data.local.database.dao.AlgebraicHistoryDao
import com.example.smartcalculator.data.local.database.dao.GraphicHistoryDao
import com.example.smartcalculator.data.local.database.dao.ProgrammerHistoryDao
import com.example.smartcalculator.data.local.database.dao.StatisticalHistoryDao
import com.example.smartcalculator.data.local.database.entities.AlgebraicHistoryEntity
import com.example.smartcalculator.data.local.database.entities.GraphicHistoryEntity
import com.example.smartcalculator.data.local.database.entities.ProgrammerHistoryEntity
import com.example.smartcalculator.data.local.database.entities.StatisticalHistoryEntity
import com.example.smartcalculator.util.Converters

@Database(
    entities = [
        AlgebraicHistoryEntity::class,
        GraphicHistoryEntity::class,
        ProgrammerHistoryEntity::class,
        StatisticalHistoryEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun algebraicHistoryDao(): AlgebraicHistoryDao
    abstract fun graphicHistoryDao(): GraphicHistoryDao
    abstract fun programmerHistoryDao(): ProgrammerHistoryDao
    abstract fun statisticalHistoryDao(): StatisticalHistoryDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "smart_calculator_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}