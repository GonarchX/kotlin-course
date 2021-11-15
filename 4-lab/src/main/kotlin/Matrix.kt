package lab4

import lab4.MatrixInstrument.Companion.createMatrixDataOfZero
import lab4.MatrixInstrument.Companion.getCopyOfMatrix
import lab4.MatrixInstrument.Companion.getDeepCopyOfMatrixData

class Matrix(inputData: Array<Array<Int>>) : Iterable<Int> {
    var dimension: Pair<Int, Int> = Pair(inputData.size, inputData[0].size)
    var data: Array<Array<Int>>

    init {
        if (inputData.size > 1)
            for (row in inputData)
                if (row.size != inputData[0].size)
                    throw IllegalArgumentException("All matrix rows must be the same size!")

        data = getDeepCopyOfMatrixData(inputData)
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            val rows = this@Matrix.dimension.second
            val length = dimension.first * dimension.second
            var i = -1

            override fun hasNext(): Boolean = i + 1 < length

            override fun next(): Int {
                i++
                return this@Matrix[i / rows, i % rows]
            }
        }
    }

    fun getRows(): Int = dimension.first

    fun getColumns(): Int = dimension.second

    operator fun set(i: Int, j: Int, value: Int) {
        data[i][j] = value
    }

    operator fun get(i: Int, j: Int): Int = data[i][j]

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
                this@Matrix[i, j] = data[i][j] + other[i, j]
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
                this@Matrix[i, j] = data[i][j] - other[i, j]
    }

    operator fun times(other: Matrix): Matrix {
        if (this@Matrix.getColumns() != other.getRows())
            throw IllegalArgumentException("Dimension of the other matrix must be equal!")

        val resultMatrix = Matrix(createMatrixDataOfZero(this@Matrix.getRows(), other.getColumns()))

        for (i in 0 until this@Matrix.getRows())
            for (j in 0 until other.getColumns())
                for (k in 0 until this@Matrix.getColumns())
                    resultMatrix[i, j] += this@Matrix[i, k] * other[k, j]

        return resultMatrix
    }

    operator fun timesAssign(other: Matrix) {
        if (this@Matrix.getColumns() != other.getRows())
            throw IllegalArgumentException("Dimension of the other matrix must be equal!")

        val tempMatrix = getCopyOfMatrix(this@Matrix)

        this@Matrix.data = createMatrixDataOfZero(this@Matrix.getRows(), other.getColumns())
        this@Matrix.dimension = Pair(data.size, data[0].size)

        for (i in 0 until tempMatrix.getRows())
            for (j in 0 until other.getColumns())
                for (k in 0 until tempMatrix.getColumns())
                    this@Matrix[i, j] += tempMatrix[i, k] * other[k, j]
    }
    //endregion

    //region Operations with scalar
    operator fun plus(scalar: Int): Matrix {
        val resultMatrix = getCopyOfMatrix(this@Matrix)

        for (i in 0 until resultMatrix.getRows())
            for (j in 0 until resultMatrix.getColumns())
                resultMatrix[i, j] += scalar

        return resultMatrix
    }

    operator fun plusAssign(scalar: Int) {
        for (i in 0 until this@Matrix.getRows())
            for (j in 0 until this@Matrix.getColumns())
                this@Matrix[i, j] += scalar
    }

    operator fun minus(scalar: Int): Matrix {
        val resultMatrix = getCopyOfMatrix(this@Matrix)

        for (i in 0 until resultMatrix.getRows())
            for (j in 0 until resultMatrix.getColumns())
                resultMatrix[i, j] -= scalar

        return resultMatrix
    }

    operator fun minusAssign(scalar: Int) {
        for (i in 0 until this@Matrix.getRows())
            for (j in 0 until this@Matrix.getColumns())
                this@Matrix[i, j] -= scalar
    }

    operator fun times(scalar: Int): Matrix {
        val resultMatrix = getCopyOfMatrix(this@Matrix)

        for (i in 0 until resultMatrix.getRows())
            for (j in 0 until resultMatrix.getColumns())
                resultMatrix[i, j] *= scalar

        return resultMatrix
    }

    operator fun timesAssign(scalar: Int) {
        for (i in 0 until this@Matrix.getRows())
            for (j in 0 until this@Matrix.getColumns())
                this@Matrix[i, j] *= scalar
    }

    operator fun div(scalar: Int): Matrix {
        val resultMatrix = getCopyOfMatrix(this@Matrix)

        for (i in 0 until resultMatrix.getRows())
            for (j in 0 until resultMatrix.getColumns())
                resultMatrix[i, j] /= scalar

        return resultMatrix
    }

    operator fun divAssign(scalar: Int) {
        for (i in 0 until this@Matrix.getRows())
            for (j in 0 until this@Matrix.getColumns())
                this@Matrix[i, j] /= scalar
    }
    //endregion

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

    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true

        if (this.javaClass != other?.javaClass)
            return false

        return this.equalsWithMatrix(other as Matrix)
    }

    private fun equalsWithMatrix (other: Matrix): Boolean{
        if (this.dimension != other.dimension)
            return false

        for (i in 0 until this@Matrix.getRows())
            for (j in 0 until this@Matrix.getColumns())
                if (this@Matrix[i, j] != other[i, j])
                    return false

        return true
    }

    override fun toString(): String {
        var stringRepresentation = ""

        for ((i, element) in this@Matrix.withIndex())
            if (i % getColumns() == getColumns() - 1)
                stringRepresentation += "$element\n"
            else
                stringRepresentation += "$element "

        return stringRepresentation
    }

    override fun hashCode(): Int {
        var result = dimension.hashCode()
        result = 31 * result + data.contentDeepHashCode()
        return result
    }
}