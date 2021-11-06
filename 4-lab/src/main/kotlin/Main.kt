package lab4

fun main() {
    var tempForFirstExample: MutableList<MutableList<Double>> =
        mutableListOf(
            mutableListOf(1.0, 2.0, 3.0),
            mutableListOf(4.0, 5.0, 6.0),
        )

    val matrix = Matrix(tempForFirstExample)

    tempForFirstExample =
        mutableListOf(
            mutableListOf(1.0),
            mutableListOf(2.0),
            mutableListOf(3.0)
        )

    var other = Matrix(tempForFirstExample)

    println("${"-".repeat(10)} Проверка операций без присвоения при работе с другой матрицей ${"-".repeat(10)}")
    println("${"-".repeat(5)} Проверка умножения ${"-".repeat(5)}")
    println("Первая матрица:\n$matrix")
    println("Вторая матрица:\n$other")
    println("Первая матрица после умножения со второй матрицей:\n${matrix * other}")

    tempForFirstExample =
        mutableListOf(
            mutableListOf(10.0, 20.0, 10.0),
            mutableListOf(30.0, 10.0, 10.0),
        )
    other = Matrix(tempForFirstExample)
    println("${"-".repeat(5)} Проверка операций: сложения, вычитания ${"-".repeat(5)}")
    println("Первая матрица:\n$matrix")
    println("Вторая матрица:\n$other")
    println("Первая матрица после сложения со второй матрицей:\n${matrix + other}")
    println("Первая матрица после вычитания со второй матрицей:\n${matrix - other}")

    //--------------------------------Проверка операций с присвоением при работе с другой матрицей

    var tempForSecondExample: MutableList<MutableList<Double>> =
        mutableListOf(
            mutableListOf(10.0, 20.0, 10.0),
            mutableListOf(30.0, 10.0, 10.0),
        )
    other = Matrix(tempForSecondExample)

    println("${"-".repeat(10)} Проверка операций с присвоением при работе с другой матрицей ${"-".repeat(10)}")
    println("${"-".repeat(5)} Проверка операций: сложения, вычитания ${"-".repeat(5)}")
    println("Первая матрица:\n$matrix")
    println("Вторая матрица:\n$other")
    matrix += other
    println("Первая матрица после сложения со второй матрицей:\n${matrix}")
    matrix -= other * 2.0
    println("Первая матрица после вычитания со второй матрицей:\n${matrix}")

    matrix += other
    tempForSecondExample =
        mutableListOf(
            mutableListOf(1.0),
            mutableListOf(2.0),
            mutableListOf(3.0)
        )

    other = Matrix(tempForSecondExample)
    println("${"-".repeat(5)} Проверка умножения ${"-".repeat(5)}")
    println("Первая матрица:\n$matrix")
    println("Вторая матрица:\n$other")
    matrix *= other
    println("Первая матрица после умножения со второй матрицей:\n${matrix}")

    println("${"-".repeat(10)} Проверка операций изменения по индексу ${"-".repeat(10)}")
    val tempChangeByIndexExample =
        mutableListOf(
            mutableListOf(1.0, 2.0, 3.0),
            mutableListOf(4.0, 5.0, 6.0),
            mutableListOf(7.0, 8.0, 9.0),
        )

    val changeByIndexMatrix = Matrix(tempChangeByIndexExample)
    println("Матрица до изменений:\n$changeByIndexMatrix")

    changeByIndexMatrix[1, 2] = 666.0
    println("Матрица после изменения элемента по индексу [1, 2] :\n$changeByIndexMatrix")

    changeByIndexMatrix[0, 0] = 999.0
    println("Матрица после изменения элемента по индексу [0, 0] :\n$changeByIndexMatrix")


    println("Элемент по индексу [1, 2] :\n${changeByIndexMatrix[1, 2]}")

    println("Элемент по индексу [0, 0] :\n${changeByIndexMatrix[0, 0]}")
}

