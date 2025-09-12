package com.example.smartcalculator.data.repository

import com.example.smartcalculator.data.local.database.dao.AlgebraicHistoryDao
import com.example.smartcalculator.data.local.database.entities.AlgebraicHistoryEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AlgebraicRepositoryImpl @Inject constructor(
    private val algebraicHistoryDao: AlgebraicHistoryDao
) : AlgebraicRepository {
    override fun getHistory(): Flow<List<AlgebraicHistoryEntity>> {
        return algebraicHistoryDao.getAll()
    }

    override suspend fun insertHistory(entity: AlgebraicHistoryEntity) {
        algebraicHistoryDao.insert(entity)
    }

    override suspend fun deleteAllHistory() {
        algebraicHistoryDao.deleteAll()
    }

    override suspend fun deleteHistoryById(id: Long?) {
        algebraicHistoryDao.deleteById(id)
    }
}