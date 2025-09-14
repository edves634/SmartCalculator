package com.example.smartcalculator.ui.settings

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartcalculator.data.model.AppTheme
import com.example.smartcalculator.data.model.CalculatorType
import com.example.smartcalculator.data.model.HistoryRetention
import com.example.smartcalculator.data.model.SettingsState
import com.example.smartcalculator.data.repository.HistoryRepository
import com.example.smartcalculator.data.repository.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsRepository: SettingsRepository,
    private val historyRepository: HistoryRepository
) : ViewModel() {

    private val _state = mutableStateOf(SettingsState())
    val state: State<SettingsState> = _state

    init {
        loadSettings()
    }

    private fun loadSettings() {
        viewModelScope.launch {
            settingsRepository.getSettings().collect { settings ->
                _state.value = _state.value.copy(settings = settings)
            }
        }
    }

    fun updateTheme(theme: AppTheme) {
        viewModelScope.launch {
            val newSettings = _state.value.settings.copy(theme = theme)
            settingsRepository.updateSettings(newSettings)
        }
    }

    fun updateHistoryRetention(retention: HistoryRetention) {
        viewModelScope.launch {
            val newSettings = _state.value.settings.copy(historyRetention = retention)
            settingsRepository.updateSettings(newSettings)

            // Применяем новую политику хранения немедленно
            CalculatorType.values().forEach { type ->
                // Получаем историю, что запустит очистку согласно новой политике
                historyRepository.getHistory(type).first()
            }
        }
    }

    fun clearAllHistory() {
        viewModelScope.launch {
            CalculatorType.values().forEach { type ->
                historyRepository.clearHistory(type)
            }
        }
    }
}