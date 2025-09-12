package com.example.smartcalculator.domain.usecase.algebraic

import com.example.smartcalculator.data.local.database.entities.AlgebraicHistoryEntity
import com.example.smartcalculator.data.repository.AlgebraicRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAlgebraicHistoryUseCase @Inject constructor(
    private val repository: AlgebraicRepository
) {
    operator fun invoke(): Flow<List<AlgebraicHistoryEntity>> {
        return repository.getHistory()
    }
}

