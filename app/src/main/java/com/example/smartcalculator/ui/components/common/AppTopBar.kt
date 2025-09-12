package com.example.smartcalculator.ui.components.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    onBackClick: (() -> Unit)? = null,
    onHistoryClick: (() -> Unit)? = null,
    onHelpClick: (() -> Unit)? = null,
    onShareClick: (() -> Unit)? = null
) {
    CenterAlignedTopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            if (onBackClick != null) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Назад"
                    )
                }
            }
        },
        actions = {
            if (onHistoryClick != null) {
                IconButton(onClick = onHistoryClick) {
                    Icon(
                        imageVector = Icons.Filled.History,
                        contentDescription = "История"
                    )
                }
            }
            if (onHelpClick != null) {
                IconButton(onClick = onHelpClick) {
                    Icon(
                        imageVector = Icons.Filled.Help,
                        contentDescription = "Справка"
                    )
                }
            }
            if (onShareClick != null) {
                IconButton(onClick = onShareClick) {
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = "Поделиться"
                    )
                }
            }
        }
    )
}