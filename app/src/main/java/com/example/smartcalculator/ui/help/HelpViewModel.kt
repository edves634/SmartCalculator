package com.example.smartcalculator.ui.help

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartcalculator.data.model.CalculatorType
import com.example.smartcalculator.data.model.HelpContent
import com.example.smartcalculator.domain.usecase.help.GetHelpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HelpViewModel @Inject constructor(
    private val getHelpUseCase: GetHelpUseCase
) : ViewModel() {

    private val _currentCalculatorType = mutableStateOf<CalculatorType?>(null)
    val currentCalculatorType = _currentCalculatorType

    private val _helpContent = mutableStateOf<HelpContent?>(null)
    val helpContent = _helpContent

    private val _isLoading = mutableStateOf(false)
    val isLoading = _isLoading

    fun setCalculatorType(calculatorType: CalculatorType?) {
        _currentCalculatorType.value = calculatorType
        loadHelpContent()
    }

    private fun loadHelpContent() {
        _currentCalculatorType.value?.let { type ->
            _isLoading.value = true
            viewModelScope.launch {
                getHelpUseCase.execute(type)
                    .catch { e ->
                        // Обработка ошибок
                        _isLoading.value = false
                    }
                    .collect { content ->
                        _helpContent.value = content
                        _isLoading.value = false
                    }
            }
        } ?: run {
            _helpContent.value = null
            _isLoading.value = false
        }
    }
}