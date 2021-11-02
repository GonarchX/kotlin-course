## Задание 3.

Реализовать набор классов, описывающий иерархию геометрических фигур (круг, квадрат, прямоугольник, треугольник). Для
каждой фигуры должен быть реализован интерфейс с методами для вычисления периметра и площади фигуры.

Реализовать класс ShapeFactory с методами для создание фигур всех типов по переданным параметрам, а также с методами,
позволяющими создавать фигуру каждого типа со случайными размерами и метод, позволяющий создавать случайную фигуру.

Все создаваемые фигуры должны быть корректными (например, квадрат со стороной отрицательного размера - не является
корректным)

Для демонстрации работы полученного кода в main создать список фигур, добавить в него по несколько фигур каждого типа.
Вывести в консоль:

* Суммарную площадь всех фигур
* Суммарный периметр всех фигур
* Фигуру с наибольшей/наименьшей площадью
* Фигуру с наибольшим/наименьшим периметром

_Опционально, чтобы получить 5 баллов (+1), необходимо добавить unit-тесты на код для созданию фигур и вычисления
площадей/периметром_

Подсказка:

```
interface Shape {
    fun calcArea(): Double
    fun calcPerimeter(): Double
}

class Circle /* implementation */
class Square /* implementation */
class Rectangle /* implementation */
class Triangle /* implementation */
```

```
interface ShapeFactory {
    fun createCircle(/* parameters */): Circle
    fun createSquare(/* parameters */): Square
    fun createRectangle(/* parameters */): Rectangle
    fun createTriangle(/* parameters */): Triangle
    
    fun createRandomCircle(): Circle
    fun createRandomSquare(): Square
    fun createRandomRectangle(): Rectangle
    fun createRandomTriangle(): Triangle
    
    fun createRandomShape(): Shape
    }
    
    class ShapeFactorImpl : ShapeFactory {
    /*  implementation */z
}
```
