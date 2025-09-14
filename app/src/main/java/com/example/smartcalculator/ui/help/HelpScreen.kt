package com.example.smartcalculator.ui.help

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HelpScreen(
    calculatorType: String,
    onBack: () -> Unit,
    viewModel: HelpViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Help for $calculatorType",
            modifier = Modifier.padding(16.dp)
        )

        // Здесь будет список помощи
        Text(
            text = "Help content will be here",
            modifier = Modifier.padding(16.dp)
        )
    }
}