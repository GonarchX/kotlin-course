package lab3

import kotlin.math.pow

interface Shape {
    fun calcArea(): Double
    fun calcPerimeter(): Double
}

class Circle(private val radius: Double) : Shape {
    init {
        if (radius < 0)
            throw IllegalArgumentException("Radius must be greater than zero!")
    }

    override fun calcArea(): Double = Math.PI * this.radius
    override fun calcPerimeter(): Double = 2 * Math.PI * this.radius
}

class Square(private val sideLen: Double) : Shape {
    init {
        if (sideLen < 0)
            throw IllegalArgumentException("Square side length must be greater than zero!")
    }

    override fun calcArea(): Double = sideLen.pow(2.0)
    override fun calcPerimeter(): Double = sideLen * 4
}

class Rectangle(private val sideLenA: Double, private val sideLenB: Double) : Shape {
    init {
        if (sideLenA < 0 || sideLenB < 0)
            throw IllegalArgumentException("Square side length be must greater than zero!")
    }

    override fun calcArea(): Double = sideLenA * sideLenB
    override fun calcPerimeter(): Double = 2 * (sideLenA + sideLenB)
}

class Triangle(private val sideLenA: Double, private val sideLenB: Double, private val sideLenC: Double) : Shape {
    private val semiPerimeter: Double = calcPerimeter() / 2

    init {
        if (sideLenA <= 0 || sideLenB <= 0 || sideLenC <= 0)
            throw IllegalArgumentException("Triangle side length must be greater than zero!")
        if (sideLenA + sideLenB <= sideLenC || sideLenA + sideLenC <= sideLenB || sideLenB + sideLenC <= sideLenA)
            throw IllegalArgumentException("The length of the side of a triangle cannot be greater than the sum of the lengths of the other two sides!")
    }

    override fun calcArea(): Double =
        kotlin.math.sqrt(semiPerimeter * (semiPerimeter - sideLenA) * (semiPerimeter - sideLenB) * (semiPerimeter - sideLenC))

    override fun calcPerimeter(): Double = sideLenA + sideLenB + sideLenC
}