package com.example.smartcalculator.ui.calculators.algebraic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartcalculator.data.model.CalculatorType
import com.example.smartcalculator.data.model.HistoryItem
import com.example.smartcalculator.domain.usecase.history.SaveHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlgebraicViewModel @Inject constructor(
    private val saveHistoryUseCase: SaveHistoryUseCase
) : ViewModel() {

    // ... остальная логика

    fun saveToHistory() {
        val currentState = state.value
        val historyItem = HistoryItem(
            id = 0, // ID будет сгенерирован базой данных
            calculatorType = CalculatorType.ALGEBRAIC,
            expression = currentState.expression,
            result = currentState.result,
            timestamp = System.currentTimeMillis()
        )
        viewModelScope.launch {
            saveHistoryUseCase(historyItem)
        }
    }
}