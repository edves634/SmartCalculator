package com.example.smartcalculator.ui.components.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    onHistoryClick: () -> Unit,
    onHelpClick: () -> Unit,
    onShareClick: () -> Unit,
    onBackClick: (() -> Unit)? = null,
    showHistory: Boolean = true
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            if (onBackClick != null) {
                IconButton(onClick = onBackClick) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        },
        actions = {
            if (showHistory) {
                IconButton(onClick = onHistoryClick) {
                    Icon(Icons.Filled.History, contentDescription = "History")
                }
            }
            IconButton(onClick = onHelpClick) {
                Icon(Icons.Filled.Help, contentDescription = "Help")
            }
            IconButton(onClick = onShareClick) {
                Icon(Icons.Filled.Share, contentDescription = "Share")
            }
        }
    )
}