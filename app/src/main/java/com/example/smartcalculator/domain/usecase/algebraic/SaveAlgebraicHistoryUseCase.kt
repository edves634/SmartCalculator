package com.example.smartcalculator.domain.usecase.algebraic

import com.example.smartcalculator.data.local.database.entities.AlgebraicHistoryEntity
import com.example.smartcalculator.data.repository.AlgebraicRepository
import javax.inject.Inject

class SaveAlgebraicHistoryUseCase @Inject constructor(
    private val repository: AlgebraicRepository
) {
    suspend operator fun invoke(entity: AlgebraicHistoryEntity) {
        repository.insertHistory(entity)
    }
}