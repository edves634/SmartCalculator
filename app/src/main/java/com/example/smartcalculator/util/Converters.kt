package com.example.smartcalculator.util

import com.example.smartcalculator.data.local.database.entities.AlgebraicHistoryEntity
import com.example.smartcalculator.data.local.database.entities.GraphicHistoryEntity
import com.example.smartcalculator.data.local.database.entities.ProgrammerHistoryEntity
import com.example.smartcalculator.data.local.database.entities.StatisticalHistoryEntity
import com.example.smartcalculator.data.model.CalculatorType
import com.example.smartcalculator.data.model.HistoryItem

class Converters {
    fun toHistoryItem(entity: AlgebraicHistoryEntity): HistoryItem {
        return HistoryItem(
            id = entity.id,
            calculatorType = CalculatorType.ALGEBRAIC,
            expression = entity.expression,
            result = entity.result,
            timestamp = entity.timestamp
        )
    }

    fun toHistoryItem(entity: GraphicHistoryEntity): HistoryItem {
        return HistoryItem(
            id = entity.id,
            calculatorType = CalculatorType.GRAPHIC,
            expression = entity.expression,
            result = entity.result,
            timestamp = entity.timestamp
        )
    }

    // ... аналогично для ProgrammerHistoryEntity и StatisticalHistoryEntity

    fun toAlgebraicEntity(item: HistoryItem): AlgebraicHistoryEntity {
        return AlgebraicHistoryEntity(
            id = item.id,
            expression = item.expression,
            result = item.result,
            timestamp = item.timestamp
        )
    }

    // ... аналогично для GraphicHistoryEntity, ProgrammerHistoryEntity, StatisticalHistoryEntity
}