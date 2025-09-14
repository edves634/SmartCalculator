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
            CalculatorType.ALGEBRAIC -> algebraicDao.getAll().map { list ->
                list.map { converters.toHistoryItem(it) }
            }
            CalculatorType.GRAPHIC -> graphicDao.getAll().map { list ->
                list.map { converters.toHistoryItem(it) }
            }
            CalculatorType.PROGRAMMER -> programmerDao.getAll().map { list ->
                list.map { converters.toHistoryItem(it) }
            }
            CalculatorType.STATISTICAL -> statisticalDao.getAll().map { list ->
                list.map { converters.toHistoryItem(it) }
            }
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
            CalculatorType.CHARTS,
            CalculatorType.QR_GENERATOR -> TODO("Implement for charts and QR generator if needed")
        }
    }

    override suspend fun saveHistory(item: HistoryItem) {
        when (item.calculatorType) {
            CalculatorType.ALGEBRAIC -> algebraicDao.insert(converters.toAlgebraicEntity(item))
            CalculatorType.GRAPHIC -> graphicDao.insert(converters.toGraphicEntity(item))
            CalculatorType.PROGRAMMER -> programmerDao.insert(converters.toProgrammerEntity(item))
            CalculatorType.STATISTICAL -> statisticalDao.insert(converters.toStatisticalEntity(item))
            CalculatorType.CHARTS,
            CalculatorType.QR_GENERATOR -> { /* Ignore - these types don't have history */ }
        }
    }

    override suspend fun deleteHistory(item: HistoryItem) {
        when (item.calculatorType) {
            CalculatorType.ALGEBRAIC -> algebraicDao.deleteById(item.id)
            CalculatorType.GRAPHIC -> graphicDao.deleteById(item.id)
            CalculatorType.PROGRAMMER -> programmerDao.deleteById(item.id)
            CalculatorType.STATISTICAL -> statisticalDao.deleteById(item.id)
            CalculatorType.CHARTS,
            CalculatorType.QR_GENERATOR -> { /* Ignore - these types don't have history */ }
        }
    }

    override suspend fun clearHistory(calculatorType: CalculatorType?) {
        when (calculatorType) {
            CalculatorType.ALGEBRAIC -> algebraicDao.deleteAll()
            CalculatorType.GRAPHIC -> graphicDao.deleteAll()
            CalculatorType.PROGRAMMER -> programmerDao.deleteAll()
            CalculatorType.STATISTICAL -> statisticalDao.deleteAll()
            null -> {
                algebraicDao.deleteAll()
                graphicDao.deleteAll()
                programmerDao.deleteAll()
                statisticalDao.deleteAll()
            }
            CalculatorType.CHARTS,
            CalculatorType.QR_GENERATOR -> { /* Ignore - these types don't have history */ }
        }
    }
}