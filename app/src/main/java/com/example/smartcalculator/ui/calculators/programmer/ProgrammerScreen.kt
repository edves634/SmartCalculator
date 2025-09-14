package com.example.smartcalculator.ui.calculators.programmer

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
fun ProgrammerScreen(
    onNavigate: (String) -> Unit,
    viewModel: ProgrammerViewModel = ProgrammerViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        AppTopBar(
            title = "Programmer Calculator",
            onHistoryClick = { onNavigate("history/PROGRAMMER") },
            onHelpClick = { onNavigate("help/PROGRAMMER") },
            onShareClick = { /* TODO */ },
            onBackClick = { onNavigate("back") }
        )

        Text(
            text = "Programmer Calculator Placeholder",
            modifier = Modifier.padding(16.dp)
        )

        // Здесь будут компоненты программистского калькулятора
    }
}

