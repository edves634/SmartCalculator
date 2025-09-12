package com.example.smartcalculator.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.White

private val LightColorScheme = lightColorScheme(
    primary = OlivePrimary,
    primaryContainer = OlivePrimaryVariant,
    secondary = OliveSecondary,
    background = BeigeBackground,
    surface = White,
    onPrimary = White,
    onSecondary = DarkText,
    onBackground = DarkText,
    onSurface = DarkText,
)

private val DarkColorScheme = darkColorScheme(
    primary = OlivePrimary,
    primaryContainer = DarkOlive,
    secondary = OliveSecondary,
    background = DarkBackground,
    surface = DarkOlive,
    onPrimary = White,
    onSecondary = White,
    onBackground = White,
    onSurface = White,
)

@Composable
fun SmartCalculatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}