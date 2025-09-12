package com.example.smartcalculator.domain.usecase.algebraic

import com.example.smartcalculator.data.repository.AlgebraicRepository
import javax.inject.Inject

class DeleteAlgebraicHistoryUseCase @Inject constructor(
    private val repository: AlgebraicRepository
) {
    suspend operator fun invoke(id: Long?) {
        repository.deleteHistoryById(id)
    }
}