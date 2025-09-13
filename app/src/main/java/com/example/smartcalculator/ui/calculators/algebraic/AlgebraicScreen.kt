package com.example.smartcalculator.ui.calculators.algebraic

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.smartcalculator.ui.components.common.AppTopBar
import com.example.smartcalculator.ui.navigation.Routes

@Composable
fun AlgebraicScreen(
    viewModel: AlgebraicViewModel = hiltViewModel(),
    onNavigate: (String) -> Unit
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Algebraic Calculator",
                onHistoryClick = { onNavigate("${Routes.HISTORY}?calculatorType=ALGEBRAIC") },
                onHelpClick = { onNavigate("${Routes.HELP}?calculatorType=ALGEBRAIC") },
                onShareClick = { /* ... */ }
            )
        }
    ) { padding ->
        // ... остальная часть экрана
    }

    // При вычислении результата сохраняем в историю
    LaunchedEffect(state.result) {
        if (state.result.isNotBlank()) {
            viewModel.saveToHistory()
        }
    }
}