package com.example.smartcalculator.data.model

data class AppSettings(
    val theme: AppTheme = AppTheme.SYSTEM,
    val historyRetention: HistoryRetention = HistoryRetention.NEVER
)

data class Settings(
    val theme: AppTheme,
    val historyRetention: HistoryRetention
)
data class SettingsState(
    val settings: Settings = Settings(AppTheme.SYSTEM, HistoryRetention.FOREVER)
)


