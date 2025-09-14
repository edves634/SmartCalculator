package com.example.smartcalculator.ui.calculators.algebraic

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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

    private val _state = mutableStateOf(AlgebraicState())
    val state: State<AlgebraicState> = _state

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
            saveHistoryUseCase.execute(historyItem)
        }
    }
}

data class AlgebraicState(
    val expression: String = "",
    val result: String = ""
)