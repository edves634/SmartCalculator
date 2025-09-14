package com.example.smartcalculator.ui.history
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HistoryScreen(
    calculatorType: String,
    onBack: () -> Unit,
    viewModel: HistoryViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "History for $calculatorType",
            modifier = Modifier.padding(16.dp)
        )

        // Здесь будет список истории
        Text(
            text = "History list will be here",
            modifier = Modifier.padding(16.dp)
        )
    }
}