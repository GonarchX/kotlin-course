package lab6

import lab3.*

fun main() {
    /*
    *   Examples with ShapeCollector<Shape>
    */
    val shapeCollector = ShapeCollector<Shape>()
    val shapeFactoryImpl = ShapeFactoryImpl()

    shapeCollector.add(shapeFactoryImpl.createRandomSquare(1.0, 3.0))
    shapeCollector.add(shapeFactoryImpl.createRandomRectangle(1.0, 3.0))
    shapeCollector.add(shapeFactoryImpl.createRandomSquare(1.0, 3.0))
    shapeCollector.addAll(
        listOf(
            shapeFactoryImpl.createRandomCircle(1.0, 3.0),
            shapeFactoryImpl.createRandomTriangle(1.0, 3.0)
        )
    )

    println("Shape collector:\n" + shapeCollector.getAll())

    println("\nSorted by area ascending:\n")
    shapeCollector.getAllSorted(ShapeComparators.compareByArea).forEach { shape -> println(shape.calcArea()) }

    println("\nSorted by area descending:\n")
    shapeCollector.getAllSorted(ShapeComparators.compareByAreaDesc).forEach { shape -> println(shape.calcArea()) }

    println("\nSorted by perimeter ascending:\n")
    shapeCollector.getAllSorted(ShapeComparators.compareByPerimeter).forEach { shape -> println(shape.calcPerimeter()) }

    println("\nSorted by perimeter descending:\n")
    shapeCollector.getAllSorted(ShapeComparators.compareByPerimeterDesc)
        .forEach { shape -> println(shape.calcPerimeter()) }

    println("\nShapes with class Square:\n${shapeCollector.getAllByClass(Square::class.java)}")

    /*
     *   Examples with ShapeCollector<Circle>
     */
    val circleCollector = ShapeCollector<Circle>()

    circleCollector.add(shapeFactoryImpl.createRandomCircle(1.0, 3.0))
    circleCollector.addAll(
        listOf(
            shapeFactoryImpl.createRandomCircle(1.0, 3.0),
            shapeFactoryImpl.createRandomCircle(1.0, 3.0)
        )
    )

    println("\n\nCircle collector:\n" + circleCollector.getAll())

    println("\nSorted by area ascending:\n")
    circleCollector.getAllSorted(ShapeComparators.compareByArea).forEach { shape -> println(shape.calcArea()) }

    println("\nSorted by area descending:\n")
    circleCollector.getAllSorted(ShapeComparators.compareByAreaDesc).forEach { shape -> println(shape.calcArea()) }

    println("\nSorted by perimeter ascending:\n")
    circleCollector.getAllSorted(ShapeComparators.compareByPerimeter)
        .forEach { shape -> println(shape.calcPerimeter()) }

    println("\nSorted by perimeter descending:\n")
    circleCollector.getAllSorted(ShapeComparators.compareByPerimeterDesc)
        .forEach { shape -> println(shape.calcPerimeter()) }

    println("\nSorted by radius ascending:\n")
    circleCollector.getAllSorted(ShapeComparators.compareByRadius).forEach { shape -> println(shape.radius) }

    println("\nSorted by radius descending:\n")
    circleCollector.getAllSorted(ShapeComparators.compareByRadiusDesc).forEach { shape -> println(shape.radius) }
}