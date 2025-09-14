package com.example.smartcalculator.domain.usecase.settings

import com.example.smartcalculator.data.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetThemeUseCase @Inject constructor(
    private val repository: SettingsRepository
) {
    operator fun invoke(): Flow<Int> {
        return repository.getThemePreference()
    }
}

