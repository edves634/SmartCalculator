package com.example.smartcalculator.data.repository

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    suspend fun setThemePreference(isDarkTheme: Boolean)
    fun getThemePreference(): Flow<Boolean>

   }