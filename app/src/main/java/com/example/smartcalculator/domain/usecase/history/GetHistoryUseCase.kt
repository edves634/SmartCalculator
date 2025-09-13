package com.example.smartcalculator.domain.usecase.history

import com.example.smartcalculator.data.model.CalculatorType
import com.example.smartcalculator.data.model.HistoryItem
import com.example.smartcalculator.data.repository.HistoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHistoryUseCase @Inject constructor(
    private val repository: HistoryRepository
) {
    operator fun invoke(calculatorType: CalculatorType? = null): Flow<List<HistoryItem>> {
        return repository.getHistory(calculatorType)
    }
}