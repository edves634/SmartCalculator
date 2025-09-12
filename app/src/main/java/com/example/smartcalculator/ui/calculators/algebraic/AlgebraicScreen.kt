package com.example.smartcalculator.ui.calculators.algebraic

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.smartcalculator.ui.components.common.AppTopBar
import com.example.smartcalculator.ui.navigation.Routes

@Composable
fun AlgebraicScreen(
    navController: NavController,
    viewModel: AlgebraicViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Алгебраический калькулятор",
                onHistoryClick = { navController.navigate("${Routes.ALGEBRAIC}/history") },
                onHelpClick = { navController.navigate("${Routes.ALGEBRAIC}/help") }
            )
        }
    ) { innerPadding ->
        AlgebraicUI(
            state = state,
            onAction = viewModel::handleAction,
            modifier = Modifier.padding(innerPadding)
        )
    }
}