package com.example.smartcalculator.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color


val OlivePrimary = Color(0xFF8A9A5B)
val OlivePrimaryVariant = Color(0xFF6B8E23)
val OliveSecondary = Color(0xFFBCB88A)
val OliveBackground = Color(0xFFF5F5DC)
val OnOlivePrimary = Color(0xFFFFFFFF)
val OnOliveBackground = Color(0xFF333333)


private val DarkColorScheme = darkColorScheme(
    primary = OlivePrimary,
    secondary = OliveSecondary,
    background = Color(0xFF1A1A1A),
    surface = Color(0xFF2D2D2D),
    onPrimary = OnOlivePrimary,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = OlivePrimary,
    primaryContainer = OlivePrimaryVariant,
    secondary = OliveSecondary,
    background = OliveBackground,
    surface = Color.White,
    onPrimary = OnOlivePrimary,
    onSecondary = Color.Black,
    onBackground = OnOliveBackground,
    onSurface = OnOliveBackground
)

// Светлая тема
val BeigeBackground = Color(0xFFF5F5DC)
val DarkText = Color(0xFF212121)

// Темная тема
val DarkBackground = Color(0xFF121212)
val DarkOlive = Color(0xFF556B2F)

// Дополнительные цвета (если нужны)
val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)

