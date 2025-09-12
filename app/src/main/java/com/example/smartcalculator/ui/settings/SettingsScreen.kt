package com.example.smartcalculator.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.smartcalculator.ui.components.common.AppTopBar


@Composable
fun SettingsScreen(
    navController: NavController,
    uiState: SettingsUiState,
    onThemeChange: (Boolean) -> Unit,

) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Настройки",
                onBackClick = { navController.popBackStack() }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            SettingsItem(
                title = "Темная тема",
                subtitle = "Включить темную тему",
                icon = Icons.Filled.DarkMode,
                isSwitchChecked = uiState.isDarkTheme,
                onSwitchChange = onThemeChange
            )

            Divider(modifier = Modifier.padding(vertical = 8.dp))

            SettingsItem(
                title = "О приложении",
                subtitle = "Версия 1.0.0",
                icon = Icons.Filled.Info,
                onClick = { /* TODO: Navigate to about screen */ }
            )
        }
    }
}