package com.example.smartcalculator.data.repository

import com.example.smartcalculator.data.model.Settings
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun getSettings(): Flow<Settings>
    suspend fun updateSettings(settings: Settings)
}