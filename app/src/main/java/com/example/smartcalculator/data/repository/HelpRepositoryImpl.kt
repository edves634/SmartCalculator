package com.example.smartcalculator.data.repository

import javax.inject.Inject
import com.example.smartcalculator.data.model.CalculatorType
import com.example.smartcalculator.data.model.HelpContent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf


class HelpRepositoryImpl @Inject constructor() : HelpRepository {
    override fun getHelpContent(calculatorType: CalculatorType): Flow<HelpContent> {
        // Здесь должна быть реальная логика получения справки
        // Пока вернем заглушку
        return flowOf(
            HelpContent(
                title = "Help for ${calculatorType.title}",
                description = calculatorType.description,
                examples = listOf("Example 1", "Example 2"),
                tips = listOf("Tip 1", "Tip 2")
            )
        )
    }
}