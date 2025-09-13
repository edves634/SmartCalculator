package com.example.smartcalculator.ui.history

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.smartcalculator.data.model.HistoryItem
import com.example.smartcalculator.ui.components.common.AppTopBar

@Composable
fun HistoryScreen(
    viewModel: HistoryViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onShareClick: () -> Unit
) {
    val calculatorType by viewModel.calculatorType.collectAsState()
    val historyItems by viewModel.historyItems.collectAsState()

    Scaffold(
        topBar = {
            AppTopBar(
                title = when (calculatorType) {
                    null -> "History"
                    else -> "${calculatorType?.name} History"
                },
                onBackClick = onBackClick,
                onShareClick = onShareClick
            )
        }
    ) { padding ->
        if (historyItems.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("No history yet")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                items(historyItems) { item ->
                    HistoryItem(
                        item = item,
                        onDelete = { viewModel.deleteHistory(item) }
                    )
                }
            }
        }
    }
}

@Composable
fun HistoryItem(item: HistoryItem, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = item.expression, style = MaterialTheme.typography.h6)
            Text(text = item.result, style = MaterialTheme.typography.body1)
            Text(
                text = "Calculator: ${item.calculatorType.name}",
                style = MaterialTheme.typography.caption
            )
            Button(onClick = onDelete) {
                Text("Delete")
            }
        }
    }
}