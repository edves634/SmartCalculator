package com.example.smartcalculator.domain.usecase.history

import com.example.smartcalculator.data.model.HistoryItem
import com.example.smartcalculator.data.repository.HistoryRepository
import javax.inject.Inject

class SaveHistoryUseCase @Inject constructor(
    private val historyRepository: HistoryRepository
) {
    suspend fun execute(historyItem: HistoryItem) {
        historyRepository.saveHistory(historyItem)
    }
}