package com.rezendev.controllers

import com.rezendev.converters.NumberConverter.isNumeric
import com.rezendev.converters.NumberConverter.convertToDouble
import com.rezendev.exceptions.UnsupportedMathOperationException
import com.rezendev.math.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong
import kotlin.math.sqrt

@RestController
class MathController {
    val counter: AtomicLong = AtomicLong()
    private val math: SimpleMath = SimpleMath()

    @RequestMapping(value = ["/sum/{n1}/{n2}"])
    fun sum(
        @PathVariable(value="n1") n1: String?,
        @PathVariable(value="n2") n2: String?
    ): Double{
        if(!isNumeric(n1) || !isNumeric(n2))
            throw UnsupportedMathOperationException("Por favor insira um valor numerico.")
        return math.sum(convertToDouble(n1), convertToDouble(n2))
    }

    @RequestMapping(value = ["/subtract/{n1}/{n2}"])
    fun subtract(
        @PathVariable(value="n1") n1: String?,
        @PathVariable(value="n2") n2: String?
    ): Double{
        if(!isNumeric(n1) || !isNumeric(n2))
            throw UnsupportedMathOperationException("Por favor insira um valor numerico.")
        return math.sub(convertToDouble(n1), convertToDouble(n2))
    }

    @RequestMapping(value = ["/multiply/{n1}/{n2}"])
    fun multiply(
        @PathVariable(value="n1") n1: String?,
        @PathVariable(value="n2") n2: String?
    ): Double{
        if(!isNumeric(n1) || !isNumeric(n2))
            throw UnsupportedMathOperationException("Por favor insira um valor numerico.")
        return math.mult(convertToDouble(n1), convertToDouble(n2))
    }

    @RequestMapping(value = ["/divide/{n1}/{n2}"])
    fun divide(
        @PathVariable(value="n1") n1: String?,
        @PathVariable(value="n2") n2: String?
    ): Double{
        if(!isNumeric(n1) || !isNumeric(n2))
            throw UnsupportedMathOperationException("Por favor insira um valor numerico.")
        return math.divide(convertToDouble(n1), convertToDouble(n2))
    }

    @RequestMapping(value = ["/average/{n1}/{n2}"])
    fun average(
        @PathVariable(value="n1") n1: String?,
        @PathVariable(value="n2") n2: String?
    ): Double{
        if(!isNumeric(n1) || !isNumeric(n2))
            throw UnsupportedMathOperationException("Por favor insira um valor numerico.")
        return math.average(convertToDouble(n1), convertToDouble(n2))
    }

    @RequestMapping(value = ["/square-root/{n1}"])
    fun square_root(
        @PathVariable(value="n1") n1: String?
    ): Double{
        if(!isNumeric(n1))
            throw UnsupportedMathOperationException("Por favor insira um valor numerico.")
        return math.squareRoot(convertToDouble(n1))
    }
}