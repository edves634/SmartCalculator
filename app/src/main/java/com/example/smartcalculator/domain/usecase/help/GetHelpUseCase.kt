package com.example.smartcalculator.domain.usecase.help

import com.example.smartcalculator.data.model.CalculatorType
import com.example.smartcalculator.data.model.HelpContent
import com.example.smartcalculator.data.repository.HelpRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHelpUseCase @Inject constructor(
    private val helpRepository: HelpRepository
) {
    fun execute(calculatorType: CalculatorType): Flow<HelpContent> {
        return helpRepository.getHelpContent(calculatorType)
    }
}