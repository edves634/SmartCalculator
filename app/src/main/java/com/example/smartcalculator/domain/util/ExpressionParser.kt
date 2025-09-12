package com.example.smartcalculator.domain.util

import java.util.*
import kotlin.math.*

object ExpressionParser {
    fun evaluate(expression: String): Double {
        return parseExpression(expression)
    }

    fun parseExpression(expression: String): Double {
        val tokens = tokenize(expression)
        val postfix = infixToPostfix(tokens)
        return evaluatePostfix(postfix)
    }

    private fun tokenize(expression: String): List<String> {
        val tokens = mutableListOf<String>()
        var current = StringBuilder()

        expression.forEach { char ->
            when {
                char.isDigit() || char == '.' -> current.append(char)
                char == ' ' -> {
                    if (current.isNotEmpty()) {
                        tokens.add(current.toString())
                        current = StringBuilder()
                    }
                }
                else -> {
                    if (current.isNotEmpty()) {
                        tokens.add(current.toString())
                        current = StringBuilder()
                    }
                    tokens.add(char.toString())
                }
            }
        }

        if (current.isNotEmpty()) {
            tokens.add(current.toString())
        }

        return tokens
    }

    private fun infixToPostfix(tokens: List<String>): List<String> {
        val output = mutableListOf<String>()
        val stack = Stack<String>()
        val precedence = mapOf(
            "+" to 1,
            "-" to 1,
            "*" to 2,
            "/" to 2,
            "%" to 2,
            "^" to 3,
            "√" to 3
        )

        tokens.forEach { token ->
            when {
                token.matches(Regex("-?\\d+(\\.\\d+)?")) -> output.add(token) // Число
                token == "(" -> stack.push(token)
                token == ")" -> {
                    while (stack.isNotEmpty() && stack.peek() != "(") {
                        output.add(stack.pop())
                    }
                    if (stack.isNotEmpty() && stack.peek() == "(") {
                        stack.pop() // Удаляем "(" из стека
                    }
                }
                precedence.containsKey(token) -> {
                    while (stack.isNotEmpty() &&
                        stack.peek() != "(" &&
                        precedence[stack.peek()]!! >= precedence[token]!!) {
                        output.add(stack.pop())
                    }
                    stack.push(token)
                }
            }
        }

        while (stack.isNotEmpty()) {
            output.add(stack.pop())
        }

        return output
    }

    private fun evaluatePostfix(postfix: List<String>): Double {
        val stack = Stack<Double>()

        postfix.forEach { token ->
            when {
                token.matches(Regex("-?\\d+(\\.\\d+)?")) -> stack.push(token.toDouble())
                else -> {
                    when (token) {
                        "+" -> {
                            val b = stack.pop()
                            val a = stack.pop()
                            stack.push(a + b)
                        }
                        "-" -> {
                            val b = stack.pop()
                            val a = stack.pop()
                            stack.push(a - b)
                        }
                        "*" -> {
                            val b = stack.pop()
                            val a = stack.pop()
                            stack.push(a * b)
                        }
                        "/" -> {
                            val b = stack.pop()
                            if (b == 0.0) throw ArithmeticException("Деление на ноль")
                            val a = stack.pop()
                            stack.push(a / b)
                        }
                        "%" -> {
                            val b = stack.pop()
                            val a = stack.pop()
                            stack.push(a % b)
                        }
                        "^" -> {
                            val b = stack.pop()
                            val a = stack.pop()
                            stack.push(a.pow(b))
                        }
                        "√" -> {
                            val a = stack.pop()
                            if (a < 0) throw ArithmeticException("Корень из отрицательного числа")
                            stack.push(sqrt(a))
                        }
                    }
                }
            }
        }

        if (stack.size != 1) throw IllegalArgumentException("Некорректное выражение")
        return stack.pop()
    }

    // Вспомогательная функция для обработки специальных функций
    fun handleSpecialFunctions(expression: String): String {
        var processed = expression

        // Обработка квадратного корня
        processed = processed.replace("√", "√")

        // Обработка квадрата
        processed = processed.replace("²", "^2")

        // Обработка процентов
        processed = processed.replace(Regex("(\\d+)%")) { matchResult ->
            val value = matchResult.groupValues[1].toDouble() / 100.0
            value.toString()
        }

        return processed
    }
}