package com.example.smartcalculator.data.repository

import com.example.smartcalculator.data.model.CalculatorType
import com.example.smartcalculator.data.model.HelpContent
import kotlinx.coroutines.flow.Flow

interface HelpRepository {
    fun getHelpContent(calculatorType: CalculatorType): Flow<HelpContent>
}