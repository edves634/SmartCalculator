package com.example.smartcalculator.ui.calculators.algebraic

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartcalculator.ui.calculators.algebraic.components.AlgebraicDisplay
import com.example.smartcalculator.ui.theme.SmartCalculatorTheme
import androidx.compose.foundation.shape.RoundedCornerShape



@Composable
fun CalculatorButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isFunction: Boolean = false
) {
    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = when {
            text == "=" -> MaterialTheme.colorScheme.primary
            text == "C" || text == "⌫" -> MaterialTheme.colorScheme.errorContainer
            isFunction -> MaterialTheme.colorScheme.secondaryContainer
            else -> MaterialTheme.colorScheme.surfaceVariant
        },
        contentColor = when {
            text == "=" -> MaterialTheme.colorScheme.onPrimary
            text == "C" || text == "⌫" -> MaterialTheme.colorScheme.onErrorContainer
            isFunction -> MaterialTheme.colorScheme.onSecondaryContainer
            else -> MaterialTheme.colorScheme.onSurfaceVariant
        }
    )

    Button(
        onClick = onClick,
        modifier = modifier
            .padding(1.dp)
            .height(48.dp)
            .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.3f), RoundedCornerShape(4.dp)),
        shape = RoundedCornerShape(4.dp),
        colors = buttonColors,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 2.dp,
            pressedElevation = 0.dp
        )
    ) {
        Text(
            text = text,
            fontSize = when {
                text.length > 3 -> 10.sp
                text.length > 2 -> 12.sp
                else -> 14.sp
            },
            fontWeight = if (isFunction) FontWeight.Medium else FontWeight.Normal,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun AlgebraicUI(
    state: AlgebraicUiState,
    onAction: (AlgebraicAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Дисплей
        AlgebraicDisplay(
            input = state.input,
            result = state.result,
            error = state.error,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        // Разделитель
        Divider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)
        )

        // Основная клавиатура
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            // Первый ряд: функции и специальные кнопки
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                CalculatorButton(
                    text = "sin",
                    onClick = { onAction(AlgebraicAction.Operation("sin(")) },
                    modifier = Modifier.weight(1f),
                    isFunction = true
                )
                CalculatorButton(
                    text = "cos",
                    onClick = { onAction(AlgebraicAction.Operation("cos(")) },
                    modifier = Modifier.weight(1f),
                    isFunction = true
                )
                CalculatorButton(
                    text = "tan",
                    onClick = { onAction(AlgebraicAction.Operation("tan(")) },
                    modifier = Modifier.weight(1f),
                    isFunction = true
                )
                CalculatorButton(
                    text = "ln",
                    onClick = { onAction(AlgebraicAction.Operation("ln(")) },
                    modifier = Modifier.weight(1f),
                    isFunction = true
                )
                CalculatorButton(
                    text = "log",
                    onClick = { onAction(AlgebraicAction.Operation("log(")) },
                    modifier = Modifier.weight(1f),
                    isFunction = true
                )
            }


// Второй ряд: дополнительные функции
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                CalculatorButton(
                    text = "x²",
                    onClick = { onAction(AlgebraicAction.Operation("^2")) },
                    modifier = Modifier.weight(1f),
                    isFunction = true
                )
                CalculatorButton(
                    text = "xʸ",
                    onClick = { onAction(AlgebraicAction.Operation("^")) },
                    modifier = Modifier.weight(1f),
                    isFunction = true
                )
                CalculatorButton(
                    text = "√",
                    onClick = { onAction(AlgebraicAction.Operation("√(")) },
                    modifier = Modifier.weight(1f),
                    isFunction = true
                )
                CalculatorButton(
                    text = "π",
                    onClick = { onAction(AlgebraicAction.Operation("π")) },
                    modifier = Modifier.weight(1f),
                    isFunction = true
                )
                CalculatorButton(
                    text = "e",
                    onClick = { onAction(AlgebraicAction.Operation("e")) },
                    modifier = Modifier.weight(1f),
                    isFunction = true
                )
            }

            // Третий ряд: цифры и основные операции
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                CalculatorButton(text = "7", onClick = { onAction(AlgebraicAction.Number(7)) }, modifier = Modifier.weight(1f))
                CalculatorButton(text = "8", onClick = { onAction(AlgebraicAction.Number(8)) }, modifier = Modifier.weight(1f))
                CalculatorButton(text = "9", onClick = { onAction(AlgebraicAction.Number(9)) }, modifier = Modifier.weight(1f))
                CalculatorButton(text = "÷", onClick = { onAction(AlgebraicAction.Operation("/")) }, modifier = Modifier.weight(1f))
                CalculatorButton(text = "C", onClick = { onAction(AlgebraicAction.Clear) }, modifier = Modifier.weight(1f))
            }

            // Четвертый ряд: цифры и основные операции
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                CalculatorButton(text = "4", onClick = { onAction(AlgebraicAction.Number(4)) }, modifier = Modifier.weight(1f))
                CalculatorButton(text = "5", onClick = { onAction(AlgebraicAction.Number(5)) }, modifier = Modifier.weight(1f))
                CalculatorButton(text = "6", onClick = { onAction(AlgebraicAction.Number(6)) }, modifier = Modifier.weight(1f))
                CalculatorButton(text = "×", onClick = { onAction(AlgebraicAction.Operation("*")) }, modifier = Modifier.weight(1f))
                CalculatorButton(text = "⌫", onClick = { onAction(AlgebraicAction.Delete) }, modifier = Modifier.weight(1f))
            }

            // Пятый ряд: цифры и основные операции
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                CalculatorButton(text = "1", onClick = { onAction(AlgebraicAction.Number(1)) }, modifier = Modifier.weight(1f))
                CalculatorButton(text = "2", onClick = { onAction(AlgebraicAction.Number(2)) }, modifier = Modifier.weight(1f))
                CalculatorButton(text = "3", onClick = { onAction(AlgebraicAction.Number(3)) }, modifier = Modifier.weight(1f))
                CalculatorButton(text = "-", onClick = { onAction(AlgebraicAction.Operation("-")) }, modifier = Modifier.weight(1f))
                CalculatorButton(text = "(", onClick = { onAction(AlgebraicAction.Operation("(")) }, modifier = Modifier.weight(1f))
            }


// Шестой ряд: цифры и основные операции
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                CalculatorButton(text = "0", onClick = { onAction(AlgebraicAction.Number(0)) }, modifier = Modifier.weight(1f))
                CalculatorButton(text = ".", onClick = { onAction(AlgebraicAction.Decimal) }, modifier = Modifier.weight(1f))
                CalculatorButton(text = "=", onClick = { onAction(AlgebraicAction.Calculate) }, modifier = Modifier.weight(1f))
                CalculatorButton(text = "+", onClick = { onAction(AlgebraicAction.Operation("+")) }, modifier = Modifier.weight(1f))
                CalculatorButton(text = ")", onClick = { onAction(AlgebraicAction.Operation(")")) }, modifier = Modifier.weight(1f))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlgebraicUIPreview() {
    SmartCalculatorTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            AlgebraicUI(
                state = AlgebraicUiState(
                    input = "15 + sin(30) × 2",
                    result = "16",
                    error = null
                ),
                onAction = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlgebraicUIErrorPreview() {
    SmartCalculatorTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            AlgebraicUI(
                state = AlgebraicUiState(
                    input = "15 / 0",
                    result = "",
                    error = "Division by zero"
                ),
                onAction = {}
            )
        }
    }
}
