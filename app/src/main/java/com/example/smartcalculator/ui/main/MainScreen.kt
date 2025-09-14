package com.example.smartcalculator.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.smartcalculator.data.model.CalculatorType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onNavigate: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Smart Calculator") },
                actions = {
                    IconButton(onClick = { onNavigate("settings") }) {
                        Icon(Icons.Filled.Settings, contentDescription = "Settings")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            CalculatorGrid(onNavigate = onNavigate)
        }
    }
}

@Composable
fun CalculatorGrid(
    onNavigate: (String) -> Unit
) {
    val calculators = listOf(
        CalculatorType.ALGEBRAIC,
        CalculatorType.PROGRAMMER,
        CalculatorType.STATISTICAL,
        CalculatorType.GRAPHIC,
        CalculatorType.CHARTS,
        CalculatorType.QR_GENERATOR
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(calculators) { calculator ->
            CalculatorCard(
                calculatorType = calculator,
                onClick = { onNavigate(calculator.routeName) }
            )
        }
    }
}