package lab4

import lab4.MatrixInstrument.Companion.createMutableListWithLists
import lab4.MatrixInstrument.Companion.getCopyOfMatrix

class Matrix(var values: MutableList<MutableList<Double>>) : Iterable<Double> {
    var dimension: Pair<Int, Int> = Pair(values.size, values[0].size)

    init {
        if (values.size > 1) {
            for (row in values) {
                if (row.size != values[0].size)
                    throw IllegalArgumentException("All matrix rows must be the same size!")
            }
        }
    }

    override fun iterator(): Iterator<Double> {
        return object : Iterator<Double> {
            val rows = this@Matrix.dimension.second
            val length = dimension.first * dimension.second
            var i = -1

            override fun hasNext(): Boolean = i + 1 < length

            override fun next(): Double {
                i++
                return this@Matrix[i / rows, i % rows]
            }
        }
    }

    fun getRows(): Int = dimension.first

    fun getColumns(): Int = dimension.second

    operator fun set(i: Int, j: Int, value: Double) {
        values[i][j] = value
    }

    operator fun get(i: Int, j: Int): Double = values[i][j]

    //region Operations with other matrix
    operator fun plus(other: Matrix): Matrix {
        if (this.dimension != other.dimension)
            throw IllegalArgumentException("Dimension of the other matrix must be equal!")

        val resultMatrix = getCopyOfMatrix(this@Matrix)
        for (i in 0 until resultMatrix.getRows())
            for (j in 0 until resultMatrix.getColumns())
                resultMatrix[i, j] += other[i, j]

        return resultMatrix
    }

    operator fun plusAssign(other: Matrix) {
        if (this.dimension != other.dimension)
            throw IllegalArgumentException("Dimension of the other matrix must be equal!")

        for (i in 0 until this@Matrix.getRows())
            for (j in 0 until this@Matrix.getColumns())
                this@Matrix[i, j] = values[i][j] + other[i, j]
    }

    operator fun minus(other: Matrix): Matrix {
        if (this.dimension != other.dimension)
            throw IllegalArgumentException("Dimension of the other matrix must be equal!")

        val resultMatrix = getCopyOfMatrix(this@Matrix)
        for (i in 0 until resultMatrix.getRows())
            for (j in 0 until resultMatrix.getColumns())
                resultMatrix[i, j] -= other[i, j]

        return resultMatrix
    }

    operator fun minusAssign(other: Matrix) {
        if (this.dimension != other.dimension)
            throw IllegalArgumentException("Dimension of the other matrix must be equal!")

        for (i in 0 until this@Matrix.getRows())
            for (j in 0 until this@Matrix.getColumns())
                this@Matrix[i, j] = values[i][j] - other[i, j]
    }

    operator fun times(other: Matrix): Matrix {
        if (this@Matrix.getColumns() != other.getRows())
            throw IllegalArgumentException("Dimension of the other matrix must be equal!")

        val resultMatrix = Matrix(createMutableListWithLists(this@Matrix.getRows(), other.getColumns()))

        for (i in 0 until this@Matrix.getRows()) {
            for (j in 0 until other.getColumns()) {
                for (k in 0 until this@Matrix.getColumns()) {
                    resultMatrix[i, j] += this@Matrix[i, k] * other[k, j]
                }
            }
        }

        return resultMatrix
    }

    operator fun timesAssign(other: Matrix) {
        if (this@Matrix.getColumns() != other.getRows())
            throw IllegalArgumentException("Dimension of the other matrix must be equal!")

        val tempMatrix = Matrix(this@Matrix.values.toMutableList())

        this@Matrix.values = createMutableListWithLists(this@Matrix.getRows(), other.getColumns())
        this@Matrix.dimension = Pair(values.size, values[0].size)

        for (i in 0 until tempMatrix.getRows()) {
            for (j in 0 until other.getColumns()) {
                for (k in 0 until tempMatrix.getColumns()) {
                    this@Matrix[i, j] += tempMatrix[i, k] * other[k, j]
                }
            }
        }
    }
    //endregion

    //region Operations with scalar
    operator fun plus(scalar: Double): Matrix {
        val resultMatrix = getCopyOfMatrix(this@Matrix)
        for (i in 0 until resultMatrix.getRows())
            for (j in 0 until resultMatrix.getColumns())
                resultMatrix[i, j] += scalar

        return resultMatrix
    }

    operator fun plusAssign(scalar: Double) {
        for (i in 0 until this@Matrix.getRows())
            for (j in 0 until this@Matrix.getColumns())
                this@Matrix[i, j] += scalar
    }

    operator fun minus(scalar: Double): Matrix {
        val resultMatrix = getCopyOfMatrix(this@Matrix)
        for (i in 0 until resultMatrix.getRows())
            for (j in 0 until resultMatrix.getColumns())
                resultMatrix[i, j] -= scalar

        return resultMatrix
    }

    operator fun minusAssign(scalar: Double) {
        for (i in 0 until this@Matrix.getRows())
            for (j in 0 until this@Matrix.getColumns())
                this@Matrix[i, j] -= scalar
    }

    operator fun times(scalar: Double): Matrix {
        val resultMatrix = getCopyOfMatrix(this@Matrix)
        for (i in 0 until resultMatrix.getRows())
            for (j in 0 until resultMatrix.getColumns())
                resultMatrix[i, j] *= scalar

        return resultMatrix
    }

    operator fun timesAssign(scalar: Double) {
        for (i in 0 until this@Matrix.getRows())
            for (j in 0 until this@Matrix.getColumns())
                this@Matrix[i, j] *= scalar
    }

    operator fun div(scalar: Double): Matrix {
        val resultMatrix = getCopyOfMatrix(this@Matrix)
        for (i in 0 until resultMatrix.getRows())
            for (j in 0 until resultMatrix.getColumns())
                resultMatrix[i, j] /= scalar

        return resultMatrix
    }

    operator fun divAssign(scalar: Double) {
        for (i in 0 until this@Matrix.getRows())
            for (j in 0 until this@Matrix.getColumns())
                this@Matrix[i, j] /= scalar
    }
    //endregion

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Matrix) return false

        if (this.dimension != other.dimension)
            return false

        for (i in 0 until this@Matrix.getRows()) {
            for (j in 0 until this@Matrix.getColumns()) {
                if (this@Matrix[i, j] != other[i, j])
                    return false
            }
        }
        return true
    }

    override fun toString(): String {
        var image = ""
        for ((i, element) in this@Matrix.withIndex()) {
            if (i % getColumns() == getColumns() - 1) {
                image += "$element\n"
            } else
                image += "$element "
        }

        return image
    }

    //region Prefix operations
    operator fun unaryMinus(): Matrix {
        val resultMatrix = getCopyOfMatrix(this@Matrix)
        for (i in 0 until resultMatrix.getRows())
            for (j in 0 until resultMatrix.getColumns())
                resultMatrix[i, j] = -this@Matrix[i, j]

        return resultMatrix
    }

    operator fun unaryPlus(): Matrix = this
    //endregion
}