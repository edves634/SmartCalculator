package com.example.smartcalculator.data.repository

import com.example.smartcalculator.data.local.datastore.PreferencesManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val preferencesManager: PreferencesManager
) : SettingsRepository {

    override fun getThemePreference(): Flow<Int> {
        return preferencesManager.themeStream
    }

    override suspend fun setThemePreference(theme: Int) {
        preferencesManager.setTheme(theme)
    }
}