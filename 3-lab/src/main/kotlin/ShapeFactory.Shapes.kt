package lab3

val standartPoint = Point()

class Point(x: Int = 0, y: Int = 0)

interface Shape {
    fun calcArea(): Double
    fun calcPerimeter(): Double
}

class Circle(var radius: Double, var centrePoint: Point) : Shape {
    init {
        if (radius < 0)
            throw IllegalArgumentException("Radius can't be negative!")
    }

    override fun calcArea(): Double = Math.PI * this.radius
    override fun calcPerimeter(): Double = 2 * Math.PI * this.radius
}

class Square : Shape {
    override fun calcArea(): Double {
        return TODO("")
    }

    override fun calcPerimeter(): Double {
        return TODO("")
    }
}

class Rectangle : Shape {
    override fun calcArea(): Double {
        return TODO("")
    }

    override fun calcPerimeter(): Double {
        return TODO("")
    }
}

class Triangle : Shape {
    override fun calcArea(): Double {
        return TODO("")
    }

    override fun calcPerimeter(): Double {
        return TODO("")
    }
}