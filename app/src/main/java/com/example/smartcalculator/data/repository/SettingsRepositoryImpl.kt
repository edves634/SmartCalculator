package com.example.smartcalculator.data.repository

import com.example.smartcalculator.data.local.datastore.PreferencesManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val preferencesManager: PreferencesManager
) : SettingsRepository {

    override suspend fun setThemePreference(isDarkTheme: Boolean) {
        preferencesManager.setThemePreference(isDarkTheme)
    }

    override fun getThemePreference(): Flow<Boolean> {
        return preferencesManager.getThemePreference
    }


}