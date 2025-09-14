package com.example.smartcalculator.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@Singleton
class PreferencesManager @Inject constructor(
    @ApplicationContext context: Context
) {
    private val dataStore = context.dataStore

    companion object {
        val THEME_KEY = intPreferencesKey("theme")
    }

    val themeStream: Flow<Int> = dataStore.data
        .map { preferences ->
            preferences[THEME_KEY] ?: 0
        }

    suspend fun setTheme(theme: Int) {
        dataStore.edit { preferences ->
            preferences[THEME_KEY] = theme
        }
    }
}