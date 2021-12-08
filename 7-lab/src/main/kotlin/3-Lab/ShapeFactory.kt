package lab3

import kotlin.random.Random

interface ShapeFactory {
    fun createCircle(radius: Double): Circle
    fun createSquare(sideLen: Double): Square
    fun createRectangle(sideLenA: Double, sideLenB: Double): Rectangle
    fun createTriangle(sideLenA: Double, sideLenB: Double, sideLenC: Double): Triangle

    fun createRandomCircle(
        radiusMinLen: Double,
        radiusMaxLen: Double
    ): Circle

    fun createRandomSquare(
        sideMinLen: Double,
        sideMaxLen: Double
    ): Square

    fun createRandomRectangle(
        sideMinLen: Double,
        sideMaxLen: Double
    ): Rectangle

    fun createRandomTriangle(
        sideMinLen: Double,
        sideMaxLen: Double
    ): Triangle

    fun createRandomShape(
        sideMinLen: Double,
        sideMaxLen: Double
    ): Shape
}

class ShapeFactoryImpl : ShapeFactory {
    override fun createCircle(radius: Double): Circle = Circle(radius)

    override fun createSquare(sideLen: Double): Square = Square(sideLen)

    override fun createRectangle(sideLenA: Double, sideLenB: Double): Rectangle = Rectangle(sideLenA, sideLenB)

    override fun createTriangle(sideLenA: Double, sideLenB: Double, sideLenC: Double): Triangle =
        Triangle(sideLenA, sideLenB, sideLenC)

    override fun createRandomCircle(radiusMinLen: Double, radiusMaxLen: Double): Circle {
        if (radiusMinLen < 0)
            throw IllegalArgumentException("The lower bound must be positive!")
        if (radiusMinLen > radiusMaxLen)
            throw IllegalArgumentException("The lower bound must be less than upper bound!")

        return Circle(Random.nextDouble(radiusMinLen, radiusMaxLen))
    }

    override fun createRandomSquare(sideMinLen: Double, sideMaxLen: Double): Square {
        if (sideMinLen < 0)
            throw IllegalArgumentException("The lower bound must be positive!")
        if (sideMinLen > sideMaxLen)
            throw IllegalArgumentException("The lower bound must be less than upper bound!")

        return Square(Random.nextDouble(sideMinLen, sideMaxLen))
    }

    override fun createRandomRectangle(sideMinLen: Double, sideMaxLen: Double): Rectangle {
        if (sideMinLen < 0)
            throw IllegalArgumentException("The lower bound must be positive!")
        if (sideMinLen > sideMaxLen)
            throw IllegalArgumentException("The lower bound must be less than upper bound!")

        return Rectangle(Random.nextDouble(sideMinLen, sideMaxLen), Random.nextDouble(sideMinLen, sideMaxLen))
    }

    override fun createRandomTriangle(sideMinLen: Double, sideMaxLen: Double): Triangle {
        if (sideMinLen < 0)
            throw IllegalArgumentException("The lower bound must be positive!")
        if (sideMinLen > sideMaxLen)
            throw IllegalArgumentException("The lower bound must be less than upper bound!")

        var sideLenA = Random.nextDouble(sideMinLen, sideMaxLen)
        var sideLenB = Random.nextDouble(sideMinLen, sideMaxLen)
        var sideLenC = Random.nextDouble(sideMinLen, sideMaxLen)

        while (sideLenA + sideLenB <= sideLenC || sideLenA + sideLenC <= sideLenB || sideLenB + sideLenC <= sideLenA) {
            sideLenA = Random.nextDouble(sideMinLen, sideMaxLen)
            sideLenB = Random.nextDouble(sideMinLen, sideMaxLen)
            sideLenC = Random.nextDouble(sideMinLen, sideMaxLen)
        }

        return Triangle(sideLenA, sideLenB, sideLenC)
    }

    override fun createRandomShape(sideMinLen: Double, sideMaxLen: Double): Shape {
        if (sideMinLen < 0)
            throw IllegalArgumentException("The lower bound must be positive!")
        if (sideMinLen > sideMaxLen)
            throw IllegalArgumentException("The lower bound must be less than upper bound!")

        return when ((0..3).random()) {
            0 -> createRandomCircle(sideMinLen, sideMaxLen)
            1 -> createRandomSquare(sideMinLen, sideMaxLen)
            2 -> createRandomRectangle(sideMinLen, sideMaxLen)
            3 -> createRandomTriangle(sideMinLen, sideMaxLen)
            else -> throw Exception("Invalid random result!")
        }
    }
}