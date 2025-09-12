package com.example.smartcalculator.ui.calculators.algebraic.help

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.smartcalculator.ui.theme.SmartCalculatorTheme

@Composable
fun AlgebraicHelpScreenPreview() {
    SmartCalculatorTheme {
        AlgebraicHelpScreenContent(
            state = AlgebraicHelpState(
                helpItems = listOf(
                    HelpItem(
                        "Основные операции",
                        "Используйте +, -, *, / для сложения, вычитания, умножения и деления."
                    ),
                    HelpItem(
                        "Функции",
                        "Доступные функции: sin, cos, tan, log, ln. Используйте скобки: sin(30)"
                    )
                ),
                isLoading = false,
                error = null
            ),
            onBackClick = {}
        )
    }
}

@Composable
fun AlgebraicHelpScreenLoadingPreview() {
    SmartCalculatorTheme {
        AlgebraicHelpScreenContent(
            state = AlgebraicHelpState(isLoading = true),
            onBackClick = {}
        )
    }
}

@Composable
fun AlgebraicHelpScreenErrorPreview() {
    SmartCalculatorTheme {
        AlgebraicHelpScreenContent(
            state = AlgebraicHelpState(error = "Ошибка загрузки данных"),
            onBackClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAlgebraicHelpScreen() {
    AlgebraicHelpScreenPreview()
}

@Preview(showBackground = true)
@Composable
fun PreviewAlgebraicHelpScreenLoading() {
    AlgebraicHelpScreenLoadingPreview()
}

@Preview(showBackground = true)
@Composable
fun PreviewAlgebraicHelpScreenError() {
    AlgebraicHelpScreenErrorPreview()
}
