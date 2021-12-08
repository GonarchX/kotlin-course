package lab7

import lab3.Shape
import lab3.ShapeFactoryImpl

fun main() {
    val sourcePath = "C:\\AAAStudy\\5sem\\kotlin-course\\7-lab\\src\\main\\kotlin\\TestFiles\\sourceFile.json"
    val resultPath = "C:\\AAAStudy\\5sem\\kotlin-course\\7-lab\\src\\main\\kotlin\\TestFiles\\resultFile.json"

    val shapeFactory: ShapeFactoryImpl = ShapeFactoryImpl()

    val decodedListOfShapes = ShapeSerializer.decode<MutableList<Shape>>(FileIO.fileReader(sourcePath))
    decodedListOfShapes.addAll(mutableListOf(
        shapeFactory.createCircle(200.0),
        shapeFactory.createSquare(400.0),
    ))

    FileIO.fileWriter(ShapeSerializer.encode(decodedListOfShapes), resultPath)

    println("Source file content:\n${FileIO.fileReader(sourcePath)}")
    println()
    println("Result file content:\n${FileIO.fileReader(resultPath)}")
}