package com.example.smartcalculator.ui.help

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartcalculator.data.model.CalculatorType
import com.example.smartcalculator.domain.usecase.help.GetHelpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HelpViewModel @Inject constructor(
    private val getHelpUseCase: GetHelpUseCase
) : ViewModel() {

    private val _currentCalculatorType = mutableStateOf<CalculatorType?>(null)
    val currentCalculatorType: State<CalculatorType?> = _currentCalculatorType

    private val _helpContent = mutableStateOf<HelpContent?>(null)
    val helpContent: State<HelpContent?> = _helpContent

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun setCalculatorType(calculatorType: CalculatorType?) {
        _currentCalculatorType.value = calculatorType
        loadHelpContent()
    }

    fun loadHelpContent() {
        _currentCalculatorType.value?.let { type ->
            _isLoading.value = true
            viewModelScope.launch {
                getHelpUseCase(type)
                    .catch { e ->
                        // Обработка ошибок
                        _isLoading.value = false
                    }
                    .collect { content ->
                        _helpContent.value = content
                        _isLoading.value = false
                    }
            }
        }
    }
}