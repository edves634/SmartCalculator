package com.example.smartcalculator.ui.calculators.algebraic.help

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlgebraicHelpViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(AlgebraicHelpState())
    val state: StateFlow<AlgebraicHelpState> = _state.asStateFlow()

    fun handleAction(action: AlgebraicHelpAction) {
        when (action) {
            AlgebraicHelpAction.LoadHelpItems -> loadHelpItems()
        }
    }

    private fun loadHelpItems() {
        _state.value = _state.value.copy(isLoading = true)

        viewModelScope.launch {
            // Имитация загрузки данных
            delay(500)

            val helpItems = listOf(
                HelpItem(
                    "Основные операции",
                    "Используйте +, -, *, / для сложения, вычитания, умножения и деления."
                ),
                HelpItem(
                    "Функции",
                    "Доступные функции: sin, cos, tan, log, ln. Используйте скобки: sin(30)"
                ),
                HelpItem(
                    "Константы",
                    "Используйте π для числа Пи и e для основания натурального логарифма."
                ),
                HelpItem(
                    "Степени и корни",
                    "Используйте ^ для степеней (2^3) и √ для квадратного корня (√4)."
                ),
                HelpItem(
                    "Приоритет операций",
                    "Операции выполняются в порядке: скобки, функции, умножение/деление, сложение/вычитание."
                )
            )

            _state.value = _state.value.copy(
                helpItems = helpItems,
                isLoading = false,
                error = null
            )
        }
    }
}