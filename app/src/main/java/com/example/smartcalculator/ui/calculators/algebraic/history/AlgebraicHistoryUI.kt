package com.example.smartcalculator.ui.calculators.algebraic.history

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smartcalculator.data.local.database.entities.AlgebraicHistoryEntity
import com.example.smartcalculator.ui.theme.SmartCalculatorTheme
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun HistoryItem(
    item: AlgebraicHistoryEntity,
    onDelete: () -> Unit
) {
    val dateFormat = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())
    val dateString = dateFormat.format(Date(item.timestamp))

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = item.expression,
                    style = MaterialTheme.typography.bodyLarge
                )
                IconButton(
                    onClick = onDelete,
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Удалить",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            }

            Text(
                text = "= ${item.result}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = dateString,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }
    }
}

@Composable
fun AlgebraicHistoryScreenPreview() {
    SmartCalculatorTheme {
        AlgebraicHistoryScreenContent(
            state = AlgebraicHistoryState(
                historyItems = listOf(
                    AlgebraicHistoryEntity(
                        id = 1,
                        expression = "2 + 2 * 2",
                        result = "6",
                        timestamp = System.currentTimeMillis()
                    ),
                    AlgebraicHistoryEntity(
                        id = 2,
                        expression = "sin(30) + cos(60)",
                        result = "1.0",
                        timestamp = System.currentTimeMillis() - 1000000
                    ),
                    AlgebraicHistoryEntity(
                        id = 3,
                        expression = "√(16) + 3^2",
                        result = "13.0",
                        timestamp = System.currentTimeMillis() - 2000000
                    )
                ),
                isLoading = false,
                error = null
            ),
            onBackClick = {},
            onDeleteItem = {},
            onClearAllHistory = {}
        )
    }
}

@Composable
fun AlgebraicHistoryScreenLoadingPreview() {
    SmartCalculatorTheme {
        AlgebraicHistoryScreenContent(
            state = AlgebraicHistoryState(isLoading = true),
            onBackClick = {},
            onDeleteItem = {},
            onClearAllHistory = {}
        )
    }
}

@Composable
fun AlgebraicHistoryScreenErrorPreview() {
    SmartCalculatorTheme {
        AlgebraicHistoryScreenContent(
            state = AlgebraicHistoryState(error = "Ошибка загрузки истории"),
            onBackClick = {},
            onDeleteItem = {},
            onClearAllHistory = {}
        )
    }
}

@Composable
fun AlgebraicHistoryScreenEmptyPreview() {
    SmartCalculatorTheme {
        AlgebraicHistoryScreenContent(
            state = AlgebraicHistoryState(historyItems = emptyList()),
            onBackClick = {},
            onDeleteItem = {},
            onClearAllHistory = {}
        )
    }
}

@Preview(showBackground = true, name = "С данными")
@Composable
fun PreviewAlgebraicHistoryScreen() {
    AlgebraicHistoryScreenPreview()
}

@Preview(showBackground = true, name = "Загрузка")
@Composable
fun PreviewAlgebraicHistoryScreenLoading() {
    AlgebraicHistoryScreenLoadingPreview()
}

@Preview(showBackground = true, name = "Ошибка")
@Composable
fun PreviewAlgebraicHistoryScreenError() {
    AlgebraicHistoryScreenErrorPreview()
}

@Preview(showBackground = true, name = "Пустая история")
@Composable
fun PreviewAlgebraicHistoryScreenEmpty() {
    AlgebraicHistoryScreenEmptyPreview()
}