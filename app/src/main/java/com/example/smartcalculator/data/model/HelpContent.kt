package com.example.smartcalculator.data.model

data class HelpContent(
    val title: String,
    val description: String,
    val examples: List<String> = emptyList(),
    val tips: List<String> = emptyList()
)