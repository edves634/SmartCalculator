package com.example.smartcalculator.data.repository

import com.example.smartcalculator.data.local.database.dao.StatisticalHistoryDao
import com.example.smartcalculator.data.local.database.entities.StatisticalHistoryEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StatisticalRepositoryImpl @Inject constructor(
    private val statisticalHistoryDao: StatisticalHistoryDao
) : StatisticalRepository {
    override fun getHistory(): Flow<List<StatisticalHistoryEntity>> {
        return statisticalHistoryDao.getAll()
    }

    override suspend fun insertHistory(entity: StatisticalHistoryEntity) {
        statisticalHistoryDao.insert(entity)
    }

    override suspend fun deleteAllHistory() {
        statisticalHistoryDao.deleteAll()
    }

    override suspend fun deleteHistoryById(id: Long) {
        statisticalHistoryDao.deleteById(id)
    }
}