package com.example.smartcalculator.domain.usecase.history

import com.example.smartcalculator.data.model.HistoryItem
import com.example.smartcalculator.data.repository.HistoryRepository
import javax.inject.Inject

class DeleteHistoryUseCase @Inject constructor(
    private val repository: HistoryRepository
) {
    suspend operator fun invoke(item: HistoryItem) {
        repository.deleteHistory(item)
    }
}