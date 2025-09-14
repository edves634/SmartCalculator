package com.example.smartcalculator.ui.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SettingsScreen(
    onBack: () -> Unit,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Settings",
            modifier = Modifier.padding(16.dp)
        )

        // Здесь будут настройки
        Text(
            text = "Settings content will be here",
            modifier = Modifier.padding(16.dp)
        )
    }
}