package lab4

fun main() {
    val matrix = Matrix(
        arrayOf(
            arrayOf(1, 2, 3),
            arrayOf(4, 5, 6),
        )
    )

    var other = Matrix(
        arrayOf(
            arrayOf(1),
            arrayOf(2),
            arrayOf(3)
        )
    )

    println("${"-".repeat(10)} Проверка операций без присвоения при работе с другой матрицей ${"-".repeat(10)}")
    println("${"-".repeat(5)} Проверка умножения ${"-".repeat(5)}")
    println("Первая матрица:\n$matrix")
    println("Вторая матрица:\n$other")
    println("Первая матрица после умножения со второй матрицей:\n${matrix * other}")

    other = Matrix(
        arrayOf(
        arrayOf(10, 20, 10),
        arrayOf(30, 10, 10),
    ))

    println("${"-".repeat(5)} Проверка операций: сложения, вычитания ${"-".repeat(5)}")
    println("Первая матрица:\n$matrix")
    println("Вторая матрица:\n$other")
    println("Первая матрица после сложения со второй матрицей:\n${matrix + other}")
    println("Первая матрица после вычитания со второй матрицей:\n${matrix - other}")

    //--------------------------------Проверка операций с присвоением при работе с другой матрицей

    other = Matrix(
        arrayOf(
            arrayOf(10, 20, 10),
            arrayOf(30, 10, 10),
        )
    )

    println("${"-".repeat(10)} Проверка операций с присвоением при работе с другой матрицей ${"-".repeat(10)}")
    println("${"-".repeat(5)} Проверка операций: сложения, вычитания ${"-".repeat(5)}")
    println("Первая матрица:\n$matrix")
    println("Вторая матрица:\n$other")
    matrix += other
    println("Первая матрица после сложения со второй матрицей:\n${matrix}")
    matrix -= other * 2
    println("Первая матрица после вычитания со второй матрицей:\n${matrix}")

    matrix += other

    other = Matrix(
        arrayOf(
            arrayOf(1),
            arrayOf(2),
            arrayOf(3)
        )
    )
    println("${"-".repeat(5)} Проверка умножения ${"-".repeat(5)}")
    println("Первая матрица:\n$matrix")
    println("Вторая матрица:\n$other")
    matrix *= other
    println("Первая матрица после умножения со второй матрицей:\n${matrix}")

    println("${"-".repeat(10)} Проверка операций изменения по индексу ${"-".repeat(10)}")

    val changeByIndexMatrix = Matrix(
        arrayOf(
            arrayOf(1, 2, 3),
            arrayOf(4, 5, 6),
            arrayOf(7, 8, 9),
        )
    )
    println("Матрица до изменений:\n$changeByIndexMatrix")

    changeByIndexMatrix[1, 2] = 666
    println("Матрица после изменения элемента по индексу [1, 2] :\n$changeByIndexMatrix")

    changeByIndexMatrix[0, 0] = 999
    println("Матрица после изменения элемента по индексу [0, 0] :\n$changeByIndexMatrix")


    println("Элемент по индексу [1, 2] :\n${changeByIndexMatrix[1, 2]}")

    println("Элемент по индексу [0, 0] :\n${changeByIndexMatrix[0, 0]}")
}