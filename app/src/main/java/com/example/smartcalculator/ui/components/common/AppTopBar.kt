package com.example.smartcalculator.ui.components.common

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.smartcalculator.R

@Composable
fun AppTopBar(
    title: String,
    onBackClick: (() -> Unit)? = null,
    onHistoryClick: (() -> Unit)? = null,
    onHelpClick: (() -> Unit)? = null,
    onShareClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            if (onBackClick != null) {
                IconButton(onClick = onBackClick) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        },
        actions = {
            if (onHistoryClick != null) {
                IconButton(onClick = onHistoryClick) {
                    Icon(Icons.Filled.History, contentDescription = "History")
                }
            }
            if (onHelpClick != null) {
                IconButton(onClick = onHelpClick) {
                    Icon(Icons.Filled.Help, contentDescription = "Help")
                }
            }
            if (onShareClick != null) {
                IconButton(onClick = onShareClick) {
                    Icon(Icons.Filled.Share, contentDescription = "Share")
                }
            }
        },
        modifier = modifier
    )
}