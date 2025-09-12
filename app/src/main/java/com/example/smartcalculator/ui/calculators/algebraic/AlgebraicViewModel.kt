package com.example.smartcalculator.ui.calculators.algebraic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartcalculator.data.local.database.entities.AlgebraicHistoryEntity
import com.example.smartcalculator.domain.usecase.algebraic.AlgebraicCalculateUseCase
import com.example.smartcalculator.domain.usecase.algebraic.SaveAlgebraicHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlgebraicViewModel @Inject constructor(
    private val calculateUseCase: AlgebraicCalculateUseCase,
    private val saveHistoryUseCase: SaveAlgebraicHistoryUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(AlgebraicUiState())
    val uiState: StateFlow<AlgebraicUiState> = _uiState.asStateFlow()

    fun handleAction(action: AlgebraicAction) {
        when (action) {
            is AlgebraicAction.Number -> onInput(action.number.toString())
            is AlgebraicAction.Operation -> onInput(action.operation)
            AlgebraicAction.Decimal -> onInput(".")
            AlgebraicAction.Calculate -> calculate()
            AlgebraicAction.Clear -> clear()
            AlgebraicAction.Delete -> delete()
            AlgebraicAction.ShowHistory -> {} // Обрабатывается в UI
            AlgebraicAction.ShowHelp -> {} // Обрабатывается в UI
        }
    }

    private fun onInput(value: String) {
        _uiState.update { state ->
            state.copy(
                input = state.input + value,
                error = null
            )
        }
    }

    private fun calculate() {
        viewModelScope.launch {
            val expression = _uiState.value.input
            if (expression.isNotBlank()) {
                try {
                    val result = calculateUseCase(expression)
                    _uiState.update { it.copy(result = result.toString(), error = null) }
                    saveHistoryUseCase(
                        AlgebraicHistoryEntity(
                            expression = expression,
                            result = result.toString(),
                            timestamp = System.currentTimeMillis()
                        )
                    )
                } catch (e: Exception) {
                    _uiState.update { it.copy(error = "Ошибка: ${e.message}") }
                }
            }
        }
    }

    private fun clear() {
        _uiState.update { AlgebraicUiState() }
    }

    private fun delete() {
        _uiState.update { state ->
            state.copy(input = state.input.dropLast(1))
        }
    }
}