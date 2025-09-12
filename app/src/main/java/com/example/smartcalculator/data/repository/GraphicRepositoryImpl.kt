package com.example.smartcalculator.data.repository

import com.example.smartcalculator.data.local.database.dao.GraphicHistoryDao
import com.example.smartcalculator.data.local.database.entities.GraphicHistoryEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GraphicRepositoryImpl @Inject constructor(
    private val graphicHistoryDao: GraphicHistoryDao
) : GraphicRepository {
    override fun getHistory(): Flow<List<GraphicHistoryEntity>> {
        return graphicHistoryDao.getAll()
    }

    override suspend fun insertHistory(entity: GraphicHistoryEntity) {
        graphicHistoryDao.insert(entity)
    }

    override suspend fun deleteAllHistory() {
        graphicHistoryDao.deleteAll()
    }

    override suspend fun deleteHistoryById(id: Long) {
        graphicHistoryDao.deleteById(id)
    }
}