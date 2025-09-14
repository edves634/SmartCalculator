package com.example.smartcalculator.ui.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartcalculator.data.model.CalculatorType
import com.example.smartcalculator.data.model.HistoryItem
import com.example.smartcalculator.domain.usecase.history.DeleteHistoryUseCase
import com.example.smartcalculator.domain.usecase.history.GetHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getHistoryUseCase: GetHistoryUseCase,
    private val deleteHistoryUseCase: DeleteHistoryUseCase
) : ViewModel() {

    private val _calculatorType = MutableStateFlow<CalculatorType?>(null)
    val calculatorType: StateFlow<CalculatorType?> = _calculatorType

    private val _historyItems = MutableStateFlow<List<HistoryItem>>(emptyList())
    val historyItems: StateFlow<List<HistoryItem>> = _historyItems

    fun setCalculatorType(type: CalculatorType?) {
        _calculatorType.value = type
        loadHistory()
    }

    private fun loadHistory() {
        viewModelScope.launch {
            getHistoryUseCase(_calculatorType.value).collect { items ->
                _historyItems.value = items
            }
        }
    }

    fun deleteHistory(item: HistoryItem) {
        viewModelScope.launch {
            deleteHistoryUseCase(item)
            loadHistory() // Перезагружаем историю после удаления
        }
    }
}