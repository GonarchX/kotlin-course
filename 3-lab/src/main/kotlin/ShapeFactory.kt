package lab3

interface ShapeFactory {
    fun createCircle(radius: Double, centrePoint: Point = standartPoint): Circle
    fun createSquare(/* parameters */): Square
    fun createRectangle(/* parameters */): Rectangle
    fun createTriangle(/* parameters */): Triangle

    fun createRandomCircle(): Circle
    fun createRandomSquare(): Square
    fun createRandomRectangle(): Rectangle
    fun createRandomTriangle(): Triangle

    fun createRandomShape(): Shape
}

class ShapeFactoryImpl : ShapeFactory {
    override fun createCircle(radius: Double, centrePoint: Point): Circle = Circle(radius, centrePoint)

    override fun createSquare(/* parameters */): Square {
        return TODO("")
    }

    override fun createRectangle(/* parameters */): Rectangle {
        return TODO("")
    }

    override fun createTriangle(/* parameters */): Triangle {
        return TODO("")
    }

    override fun createRandomCircle(): Circle {
        return TODO("")
    }

    override fun createRandomSquare(): Square {
        return TODO("")
    }

    override fun createRandomRectangle(): Rectangle {
        return TODO("")
    }

    override fun createRandomTriangle(): Triangle {
        return TODO("")
    }

    override fun createRandomShape(): Shape {
        return TODO("")
    }
}