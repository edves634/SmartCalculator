package com.example.smartcalculator.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState

    // Здесь можно добавить логику для главного экрана
    fun loadCalculators() {
        viewModelScope.launch {
            // Загрузка данных, если необходимо
        }
    }
}

data class MainUiState(
    val isLoading: Boolean = false,
    val error: String? = null
)