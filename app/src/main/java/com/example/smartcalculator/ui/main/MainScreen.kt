package com.example.smartcalculator.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartcalculator.ui.components.common.MainTopBar
import com.example.smartcalculator.ui.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorCard(
    calculator: Calculator,
    onCardClick: () -> Unit
) {
    Card(
        onClick = onCardClick,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .aspectRatio(1f)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = calculator.icon,
                contentDescription = calculator.title,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = calculator.title,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = calculator.description,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
        }
    }
}

val calculators = listOf(
    Calculator(
        type = CalculatorType.ALGEBRAIC,
        title = "Алгебраический",
        description = "Базовые вычисления",
        icon = Icons.Filled.Calculate,
        route = Routes.ALGEBRAIC
    ),
    Calculator(
        type = CalculatorType.GRAPHIC,
        title = "Графический",
        description = "Построение графиков",
        icon = Icons.Filled.ShowChart,
        route = Routes.GRAPHIC
    ),
    Calculator(
        type = CalculatorType.STATISTICAL,
        title = "Статистический",
        description = "Статистические расчеты",
        icon = Icons.Filled.PieChart,
        route = Routes.STATISTICAL
    ),
    Calculator(
        type = CalculatorType.PROGRAMMER,
        title = "Программистский",
        description = "Работа с системами счисления",
        icon = Icons.Filled.Code,
        route = Routes.PROGRAMMER
    ),
    Calculator(
        type = CalculatorType.CHARTS,
        title = "Диаграммы",
        description = "Построение диаграмм",
        icon = Icons.Filled.Timeline,
        route = Routes.CHARTS
    ),
    Calculator(
        type = CalculatorType.QR_GENERATOR,
        title = "QR-Генератор",
        description = "Создание QR-кодов",
        icon = Icons.Filled.QrCode,
        route = Routes.QR_GENERATOR
    )
)

@Composable
fun MainScreen(navController: NavController) {
    // Здесь будет логика смены темы
    val isDarkTheme = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            MainTopBar(
                title = "Smart Calculator",
                onThemeClick = {
                    // Переключение темы
                    isDarkTheme.value = !isDarkTheme.value
                }
            )
        }
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(padding),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(calculators) { calculator ->
                CalculatorCard(
                    calculator = calculator,
                    onCardClick = { navController.navigate(calculator.route) }
                )
            }
        }
    }
}


enum class CalculatorType {
    ALGEBRAIC, GRAPHIC, STATISTICAL, PROGRAMMER, CHARTS, QR_GENERATOR
}

data class Calculator(
    val type: CalculatorType,
    val title: String,
    val description: String,
    val icon: ImageVector,
    val route: String
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    MainScreen(navController = rememberNavController())
}