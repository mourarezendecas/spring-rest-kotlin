package com.rezendev.math

import kotlin.math.sqrt

class SimpleMath {
    fun sum (numberOne: Double, numberTwo: Double): Double = numberOne + numberTwo
    fun sub (numberOne: Double, numberTwo: Double): Double = numberOne - numberTwo
    fun mult (numberOne: Double, numberTwo: Double): Double = numberOne * numberTwo
    fun divide (numberOne: Double, numberTwo: Double): Double = numberOne / numberTwo
    fun average (numberOne: Double, numberTwo: Double): Double = (numberOne + numberTwo)/2
    fun squareRoot (numberOne: Double): Double = sqrt(numberOne)
}