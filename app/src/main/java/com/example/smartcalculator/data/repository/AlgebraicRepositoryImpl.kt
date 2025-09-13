package com.example.smartcalculator.data.repository

import com.example.smartcalculator.data.local.database.dao.AlgebraicHistoryDao
import com.example.smartcalculator.data.local.database.dao.AlgebraicHistoryEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AlgebraicRepositoryImpl @Inject constructor(
    private val dao: AlgebraicHistoryDao
) : AlgebraicRepository {
    override suspend fun saveHistory(item: AlgebraicHistoryEntity) {
        dao.insert(item)
    }

    override fun getHistory(): Flow<List<AlgebraicHistoryEntity>> {
        return dao.getAll()
    }
}