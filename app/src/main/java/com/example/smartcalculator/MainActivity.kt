package com.example.smartcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.smartcalculator.ui.navigation.AppNavHost
import com.example.smartcalculator.ui.theme.SmartCalculatorTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartCalculatorTheme {
                AppNavHost()
            }
        }
    }
}