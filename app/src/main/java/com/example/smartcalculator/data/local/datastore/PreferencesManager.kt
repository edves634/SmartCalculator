package com.example.smartcalculator.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings_preferences")

@Singleton
class PreferencesManager @Inject constructor(
    @ApplicationContext context: Context
) {
    private val dataStore = context.createDataStore(name = "settings")

    val themeStream: Flow<Int> = dataStore.data
        .map { preferences ->
            preferences[THEME_KEY] ?: 0
        }

    suspend fun setTheme(theme: Int) {
        dataStore.edit { preferences ->
            preferences[THEME_KEY] = theme
        }
    }

    companion object {
        val THEME_KEY = intPreferencesKey("theme")
    }


    val getThemePreference: Flow<Boolean> = dataStore.data
        .map { preferences ->
            preferences[THEME_PREFERENCE_KEY] ?: false
        }

    suspend fun setVibrationPreference(isEnabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[VIBRATION_PREFERENCE_KEY] = isEnabled
        }
    }

    val getVibrationPreference: Flow<Boolean> = dataStore.data
        .map { preferences ->
            preferences[VIBRATION_PREFERENCE_KEY] ?: true
        }

    suspend fun setLanguagePreference(language: String) {
        dataStore.edit { preferences ->
            preferences[LANGUAGE_PREFERENCE_KEY] = language
        }
    }

    val getLanguagePreference: Flow<String> = dataStore.data
        .map { preferences ->
            preferences[LANGUAGE_PREFERENCE_KEY] ?: "ru"
        }
}
