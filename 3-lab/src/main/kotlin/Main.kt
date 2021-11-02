package lab3

fun main() {
    val testShapeFactory : ShapeFactory = ShapeFactoryImpl()

    val circle = testShapeFactory.createCircle(5.0)
    println(circle.calcArea())
    println(circle.calcPerimeter())
}