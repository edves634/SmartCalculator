package com.example.smartcalculator.data.repository

import com.example.smartcalculator.data.local.database.dao.AlgebraicHistoryDao
import com.example.smartcalculator.data.local.database.dao.GraphicHistoryDao
import com.example.smartcalculator.data.local.database.dao.ProgrammerHistoryDao
import com.example.smartcalculator.data.local.database.dao.StatisticalHistoryDao
import com.example.smartcalculator.data.model.CalculatorType
import com.example.smartcalculator.data.model.HistoryItem
import com.example.smartcalculator.util.Converters
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
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
            CalculatorType.ALGEBRAIC -> algebraicDao.getAll().map { list -> list.map { converters.toHistoryItem(it) } }
            CalculatorType.GRAPHIC -> graphicDao.getAll().map { list -> list.map { converters.toHistoryItem(it) } }
            CalculatorType.PROGRAMMER -> programmerDao.getAll().map { list -> list.map { converters.toHistoryItem(it) } }
            CalculatorType.STATISTICAL -> statisticalDao.getAll().map { list -> list.map { converters.toHistoryItem(it) } }
            null -> {
                combine(
                    algebraicDao.getAll().map { list -> list.map { converters.toHistoryItem(it) } },
                    graphicDao.getAll().map { list -> list.map { converters.toHistoryItem(it) } },
                    programmerDao.getAll().map { list -> list.map { converters.toHistoryItem(it) } },
                    statisticalDao.getAll().map { list -> list.map { converters.toHistoryItem(it) } }
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
            else -> throw IllegalArgumentException("Unknown calculator type")
        }
    }

    override suspend fun deleteHistory(item: HistoryItem) {
        when (item.calculatorType) {
            CalculatorType.ALGEBRAIC -> algebraicDao.delete(converters.toAlgebraicEntity(item))
            CalculatorType.GRAPHIC -> graphicDao.delete(converters.toGraphicEntity(item))
            CalculatorType.PROGRAMMER -> programmerDao.delete(converters.toProgrammerEntity(item))
            CalculatorType.STATISTICAL -> statisticalDao.delete(converters.toStatisticalEntity(item))
            else -> throw IllegalArgumentException("Unknown calculator type")
        }
    }

    override suspend fun clearHistory(calculatorType: CalculatorType?) {
        when (calculatorType) {
            CalculatorType.ALGEBRAIC -> algebraicDao.clear()
            CalculatorType.GRAPHIC -> graphicDao.clear()
            CalculatorType.PROGRAMMER -> programmerDao.clear()
            CalculatorType.STATISTICAL -> statisticalDao.clear()
            null -> {
                algebraicDao.clear()
                graphicDao.clear()
                programmerDao.clear()
                statisticalDao.clear()
            }
        }
    }
}