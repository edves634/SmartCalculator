package com.example.smartcalculator.ui.calculators.algebraic.history

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlgebraicHistoryScreen(
    navController: NavHostController,
    viewModel: AlgebraicHistoryViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.handleAction(AlgebraicHistoryAction.LoadHistory)
    }

    AlgebraicHistoryScreenContent(
        state = state,
        onBackClick = { navController.popBackStack() },
        onDeleteItem = { id -> viewModel.handleAction(AlgebraicHistoryAction.DeleteItem(id)) },
        onClearAllHistory = { viewModel.handleAction(AlgebraicHistoryAction.ClearAllHistory) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlgebraicHistoryScreenContent(
    state: AlgebraicHistoryState,
    onBackClick: () -> Unit,
    onDeleteItem: (Long) -> Unit,
    onClearAllHistory: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("История вычислений") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    IconButton(
                        onClick = onClearAllHistory,
                        enabled = state.historyItems.isNotEmpty()
                    ) {
                        Icon(Icons.Default.Delete, contentDescription = "Очистить историю")
                    }
                }
            )
        }
    ) { innerPadding ->
        if (state.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else if (state.error != null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text("Ошибка загрузки: ${state.error}")
            }
        } else if (state.historyItems.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text("История вычислений пуста")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                items(state.historyItems) { item ->
                    HistoryItem(
                        item = item,
                        onDelete = { onDeleteItem(item.id) }
                    )
                    Divider()
                }
            }
        }
    }
}