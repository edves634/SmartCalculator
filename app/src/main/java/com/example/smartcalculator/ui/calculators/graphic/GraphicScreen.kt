package com.example.smartcalculator.ui.calculators.graphic

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.example.smartcalculator.ui.components.common.AppTopBar
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@Composable
fun GraphicScreen(
    onNavigate: (String) -> Unit,
    viewModel: GraphicViewModel = GraphicViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        AppTopBar(
            title = "Graphic Calculator",
            onHistoryClick = { onNavigate("history/GRAPHIC") },
            onHelpClick = { onNavigate("help/GRAPHIC") },
            onShareClick = { /* TODO */ },
            onBackClick = { onNavigate("back") }
        )

        Text(
            text = "Graphic Calculator Placeholder",
            modifier = Modifier.padding(16.dp)
        )

        // Здесь будут компоненты графического калькулятора
    }
}

