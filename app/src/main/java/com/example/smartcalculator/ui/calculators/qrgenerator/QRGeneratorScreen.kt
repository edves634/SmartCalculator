package com.example.smartcalculator.ui.calculators.qrgenerator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.smartcalculator.ui.components.common.AppTopBar

@Composable
fun QRGeneratorScreen(
    onNavigate: (String) -> Unit,
    viewModel: QRGeneratorViewModel = QRGeneratorViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        AppTopBar(
            title = "QR Generator",
            onHistoryClick = { /* QR Generator doesn't have history */ },
            onHelpClick = { onNavigate("help/QR_GENERATOR") },
            onShareClick = { /* TODO */ },
            onBackClick = { onNavigate("back") }
        )

        Text(
            text = "QR Generator Placeholder",
            modifier = Modifier.padding(16.dp)
        )

        // Здесь будут компоненты генератора QR-кодов
    }
}


