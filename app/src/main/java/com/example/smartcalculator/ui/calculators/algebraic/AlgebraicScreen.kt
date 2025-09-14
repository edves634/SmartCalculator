package com.example.smartcalculator.ui.calculators.algebraic

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
fun AlgebraicScreen(
    onNavigate: (String) -> Unit,
    viewModel: AlgebraicViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        AppTopBar(
            title = "Algebraic Calculator",
            onHistoryClick = { onNavigate("history/ALGEBRAIC") },
            onHelpClick = { onNavigate("help/ALGEBRAIC") },
            onShareClick = { /* TODO */ },
            onBackClick = { onNavigate("back") }
        )

        Text(
            text = "Algebraic Calculator Placeholder",
            modifier = Modifier.padding(16.dp)
        )

        // Здесь будут компоненты калькулятора
    }
}