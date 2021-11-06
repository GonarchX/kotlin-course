## Задание 4.
Необходимо реализовать класс для работы с двумерными матрицами (можно выбрать любой числовой тип данных для элементов матрицы)

Класс должен предоставлять возможности для:
* инициализации матрицы
* просмотра значения элемента в позиции (i,j) и изменения этого элемента через оператор [ ]
* просмотра размерностей матрицы
* выполнения арифметических действий над матрицами через операторы +, -, *, +=, -+, *=. 	Уточнение: оператор “+” должен создавать новую матрицу и не меняет состояние матриц слева и справа от оператора. Оператор “+=” должен модифицировать матрицу слева (см. подсказку). Аналогично для других пар операторов.
* умножения/деления матрицы на скаляр через операторы *, /, *=, /=
* использования операторов унарного минуса и плюса
* сравнения двух матриц ==
* Вывод состояния матрицы в строку - toString()

В случае, если какая-то операция не может быть выполнена должен быть выброшен соответствующий Exception.
Продемонстрировать работы всех методов в main

_Опционально, чтобы получить 5 баллов (+1), необходимо выполнить хотя одно из следующих дополнений:
* Разделить реализацию на иерархию из неизменяемой и изменяемой матрицы (Matrix, MutableMatrix)
* Добавить unit-тесты_

### [**Документация**](https://kotlinlang.org/docs/operator-overloading.html)

Подсказка:

```kotlin
class Matrix {
// ...
operator fun plus(other: Matrix): Matrix {
TODO("Not yet implemented")
}

operator fun plusAssign(other: Matrix) {
TODO("Not yet implemented")
}

operator fun times(scalar: Double) {
TODO("Not yet implemented")
}

operator fun timesAssign(scalar: Double) {
TODO("Not yet implemented")
}

operator fun set(i: Int, j: Int, value: Double) {
TODO("Not yet implemented")
}

operator fun get(i: Int, j: Int): Double {
TODO("Not yet implemented")
}

operator fun unaryMinus(): Matrix {
TODO("Not yet implemented")
}

operator fun unaryPlus(): Matrix {
return this
}
// ...
}
```
