package com.example.smartcalculator.ui.calculators.algebraic.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartcalculator.domain.usecase.algebraic.DeleteAlgebraicHistoryUseCase
import com.example.smartcalculator.domain.usecase.algebraic.GetAlgebraicHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlgebraicHistoryViewModel @Inject constructor(
    private val getHistoryUseCase: GetAlgebraicHistoryUseCase,
    private val deleteHistoryUseCase: DeleteAlgebraicHistoryUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(AlgebraicHistoryState())
    val state: StateFlow<AlgebraicHistoryState> = _state.asStateFlow()

    init {
        loadHistory()
    }

    fun handleAction(action: AlgebraicHistoryAction) {
        when (action) {
            AlgebraicHistoryAction.LoadHistory -> loadHistory()
            is AlgebraicHistoryAction.DeleteItem -> deleteItem(action.id)
            AlgebraicHistoryAction.ClearAllHistory -> clearAllHistory()
        }
    }

    private fun loadHistory() {
        _state.value = _state.value.copy(isLoading = true)

        viewModelScope.launch {
            getHistoryUseCase()
                .catch { e ->
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = e.message ?: "Неизвестная ошибка"
                    )
                }
                .collect { history ->
                    _state.value = _state.value.copy(
                        historyItems = history,
                        isLoading = false,
                        error = null
                    )
                }
        }
    }

    private fun deleteItem(id: Long) {
        viewModelScope.launch {
            try {
                deleteHistoryUseCase(id)
                // История автоматически обновится через Flow
            } catch (e: Exception) {
                _state.value = _state.value.copy(error = e.message)
            }
        }
    }

    private fun clearAllHistory() {
        viewModelScope.launch {
            try {
                deleteHistoryUseCase(null)
                // История автоматически обновится через Flow
            } catch (e: Exception) {
                _state.value = _state.value.copy(error = e.message)
            }
        }
    }
}