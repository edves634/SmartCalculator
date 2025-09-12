package com.example.smartcalculator.data.repository

import com.example.smartcalculator.data.local.database.dao.ProgrammerHistoryDao
import com.example.smartcalculator.data.local.database.entities.ProgrammerHistoryEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProgrammerRepositoryImpl @Inject constructor(
    private val programmerHistoryDao: ProgrammerHistoryDao
) : ProgrammerRepository {
    override fun getHistory(): Flow<List<ProgrammerHistoryEntity>> {
        return programmerHistoryDao.getAll()
    }

    override suspend fun insertHistory(entity: ProgrammerHistoryEntity) {
        programmerHistoryDao.insert(entity)
    }

    override suspend fun deleteAllHistory() {
        programmerHistoryDao.deleteAll()
    }

    override suspend fun deleteHistoryById(id: Long) {
        programmerHistoryDao.deleteById(id)
    }
}