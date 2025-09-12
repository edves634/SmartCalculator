package com.example.smartcalculator.domain.usecase.settings

import com.example.smartcalculator.data.repository.SettingsRepository
import javax.inject.Inject

class SaveThemeUseCase @Inject constructor(
    private val repository: SettingsRepository
) {
    suspend operator fun invoke(isDarkTheme: Boolean) {
        repository.setThemePreference(isDarkTheme)
    }
}