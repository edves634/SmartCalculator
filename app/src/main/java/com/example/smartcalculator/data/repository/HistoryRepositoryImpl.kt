package com.example.smartcalculator.data.repository

import com.example.smartcalculator.data.local.database.dao.AlgebraicHistoryDao
import com.example.smartcalculator.data.local.database.dao.GraphicHistoryDao
import com.example.smartcalculator.data.local.database.dao.ProgrammerHistoryDao
import com.example.smartcalculator.data.local.database.dao.StatisticalHistoryDao
import com.example.smartcalculator.data.model.CalculatorType
import com.example.smartcalculator.data.model.HistoryItem
import com.example.smartcalculator.util.Converters
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HistoryRepositoryImpl @Inject constructor(
    private val algebraicDao: AlgebraicHistoryDao,
    private val graphicDao: GraphicHistoryDao,
    private val programmerDao: ProgrammerHistoryDao,
    private val statisticalDao: StatisticalHistoryDao,
    private val converters: Converters
) : HistoryRepository {

    override fun getHistory(calculatorType: CalculatorType?): Flow<List<HistoryItem>> {
        return when (calculatorType) {
            CalculatorType.ALGEBRAIC -> algebraicDao.getAll().map { it.map(converters::toHistoryItem) }
            CalculatorType.GRAPHIC -> graphicDao.getAll().map { it.map(converters::toHistoryItem) }
            CalculatorType.PROGRAMMER -> programmerDao.getAll().map { it.map(converters::toHistoryItem) }
            CalculatorType.STATISTICAL -> statisticalDao.getAll().map { it.map(converters::toHistoryItem) }
            null -> {
                combine(
                    algebraicDao.getAll().map { it.map(converters::toHistoryItem) },
                    graphicDao.getAll().map { it.map(converters::toHistoryItem) },
                    programmerDao.getAll().map { it.map(converters::toHistoryItem) },
                    statisticalDao.getAll().map { it.map(converters::toHistoryItem) }
                ) { algebraic, graphic, programmer, statistical ->
                    (algebraic + graphic + programmer + statistical).sortedByDescending { it.timestamp }
                }
            }
        }
    }

    override suspend fun saveHistory(item: HistoryItem) {
        when (item.calculatorType) {
            CalculatorType.ALGEBRAIC -> algebraicDao.insert(converters.toAlgebraicEntity(item))
            CalculatorType.GRAPHIC -> graphicDao.insert(converters.toGraphicEntity(item))
            CalculatorType.PROGRAMMER -> programmerDao.insert(converters.toProgrammerEntity(item))
            CalculatorType.STATISTICAL -> statisticalDao.insert(converters.toStatisticalEntity(item))
        }
    }

    // Остальные методы
}