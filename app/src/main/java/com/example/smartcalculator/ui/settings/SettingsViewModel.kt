package com.example.smartcalculator.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartcalculator.data.repository.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsRepository: SettingsRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()

    init {
        loadSettings()
    }

    private fun loadSettings() {
        viewModelScope.launch {
            settingsRepository.getThemePreference().collect { isDarkTheme ->
                _uiState.update { it.copy(isDarkTheme = isDarkTheme) }
            }
        }

    }

    fun setThemePreference(isDarkTheme: Boolean) {
        viewModelScope.launch {
            settingsRepository.setThemePreference(isDarkTheme)
        }
    }


}

data class SettingsUiState(
    val isDarkTheme: Boolean = false,
    val isVibrationEnabled: Boolean = true,
    val language: String = "ru"
)