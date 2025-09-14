package com.example.smartcalculator.util

import com.example.smartcalculator.data.local.database.entities.AlgebraicHistoryEntity
import com.example.smartcalculator.data.local.database.entities.GraphicHistoryEntity
import com.example.smartcalculator.data.local.database.entities.ProgrammerHistoryEntity
import com.example.smartcalculator.data.local.database.entities.StatisticalHistoryEntity
import com.example.smartcalculator.data.model.CalculatorType
import com.example.smartcalculator.data.model.HistoryItem

class Converters {
    // Методы преобразования Entity в HistoryItem
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

    fun toHistoryItem(entity: ProgrammerHistoryEntity): HistoryItem {
        return HistoryItem(
            id = entity.id,
            calculatorType = CalculatorType.PROGRAMMER,
            expression = entity.expression,
            result = entity.result,
            timestamp = entity.timestamp
        )
    }

    fun toHistoryItem(entity: StatisticalHistoryEntity): HistoryItem {
        return HistoryItem(
            id = entity.id,
            calculatorType = CalculatorType.STATISTICAL,
            expression = entity.expression,
            result = entity.result,
            timestamp = entity.timestamp
        )
    }

    // Методы преобразования HistoryItem в Entity
    fun toAlgebraicEntity(item: HistoryItem): AlgebraicHistoryEntity {
        return AlgebraicHistoryEntity(
            id = item.id,
            expression = item.expression,
            result = item.result,
            timestamp = item.timestamp
        )
    }

    fun toGraphicEntity(item: HistoryItem): GraphicHistoryEntity {
        return GraphicHistoryEntity(
            id = item.id,
            expression = item.expression,
            result = item.result,
            timestamp = item.timestamp
        )
    }

    fun toProgrammerEntity(item: HistoryItem): ProgrammerHistoryEntity {
        return ProgrammerHistoryEntity(
            id = item.id,
            expression = item.expression,
            result = item.result,
            timestamp = item.timestamp
        )
    }

    fun toStatisticalEntity(item: HistoryItem): StatisticalHistoryEntity {
        return StatisticalHistoryEntity(
            id = item.id,
            expression = item.expression,
            result = item.result,
            timestamp = item.timestamp
        )
    }
}