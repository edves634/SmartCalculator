package com.example.smartcalculator.ui.calculators.statistical

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.smartcalculator.ui.components.common.AppTopBar

@Composable
fun StatisticalScreen(
    onNavigate: (String) -> Unit,
    viewModel: StatisticalViewModel = StatisticalViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        AppTopBar(
            title = "Statistical Calculator",
            onHistoryClick = { onNavigate("history/STATISTICAL") },
            onHelpClick = { onNavigate("help/STATISTICAL") },
            onShareClick = { /* TODO */ },
            onBackClick = { onNavigate("back") }
        )

        Text(
            text = "Statistical Calculator Placeholder",
            modifier = Modifier.padding(16.dp)
        )

        // Здесь будут компоненты статистического калькулятора
    }
}

