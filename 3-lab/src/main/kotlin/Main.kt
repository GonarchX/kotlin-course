package lab3

fun main() {
    val shapeFactory: ShapeFactory = ShapeFactoryImpl()

    val listOfShapes: List<Shape> = listOf(
        shapeFactory.createCircle(),
        shapeFactory.createCircle(5.0),
        shapeFactory.createSquare(),
        shapeFactory.createSquare(5.0),
        shapeFactory.createRectangle(),
        shapeFactory.createRectangle(5.0, 3.0),
        shapeFactory.createTriangle(),
        shapeFactory.createTriangle(1.0, 1.0, 1.0),
    )
    println("Non random shapes statistic:")
    println("Shape with min area: ${listOfShapes.minByOrNull { it.calcArea() }}")
    println("Shape with max area: ${listOfShapes.maxByOrNull { it.calcArea() }}")
    println("Sum area: ${listOfShapes.sumOf { it.calcArea() }}")
    println("Sum perimeter: ${listOfShapes.sumOf { it.calcPerimeter() }}")

    val listOfRandomShapes: List<Shape> = listOf(
        shapeFactory.createRandomCircle(),
        shapeFactory.createRandomCircle(1.0, 10.0),
        shapeFactory.createRandomSquare(),
        shapeFactory.createRandomSquare(1.0, 10.0),
        shapeFactory.createRandomRectangle(),
        shapeFactory.createRandomRectangle(1.0, 10.0),
        shapeFactory.createRandomTriangle(),
        shapeFactory.createRandomTriangle(1.0, 10.0),
    )

    println("\nRandom shapes statistic:")
    println("Shape with min area: ${listOfRandomShapes.minByOrNull { it.calcArea() }}")
    println("Shape with max area: ${listOfRandomShapes.maxByOrNull { it.calcArea() }}")
    println("Sum area: ${listOfRandomShapes.sumOf { it.calcArea() }}")
    println("Sum perimeter: ${listOfRandomShapes.sumOf { it.calcPerimeter() }}")
}