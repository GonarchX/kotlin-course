import lab4.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import lab4.MatrixInstrument.Companion.getCopyOfMatrix

class Matrix_Test() {
    //region Operations with another matrix tests
    @Test
    fun plus_WithMatrix() {
        val matrix = Matrix(
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6),
            )
        )
        val copyOfMatrix = getCopyOfMatrix(matrix)

        val anotherMatrix = Matrix(
            arrayOf(
                arrayOf(10, 20, 10),
                arrayOf(30, 10, 10),
            )
        )

        val copyOfAnotherMatrix = getCopyOfMatrix(anotherMatrix)

        val expectedValues = arrayOf(
            arrayOf(11, 22, 13),
            arrayOf(34, 15, 16),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 3)

        //checking that the operation was successful
        for (i in 0 until matrix.getRows())
            for (j in 0 until matrix.getColumns())
                assertEquals(expectedValues[i][j], (matrix + anotherMatrix).data[i][j])
        assertEquals(expectedDimensions, (matrix + anotherMatrix).dimension)

        //checking that the matrix does not change
        assertEquals(true, copyOfMatrix == matrix)
        assertEquals(true, copyOfAnotherMatrix == anotherMatrix)
    }

    @Test
    fun minusWithMatrix() {
        val matrix = Matrix(
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6),
            )
        )

        val copyOfMatrix = getCopyOfMatrix(matrix)

        val anotherMatrix = Matrix(
            arrayOf(
                arrayOf(10, 20, 10),
                arrayOf(30, 10, 10),
            )
        )

        val copyOfAnotherMatrix = getCopyOfMatrix(anotherMatrix)

        val expectedValues = arrayOf(
            arrayOf(-9, -18, -7),
            arrayOf(-26, -5, -4),
        )

        val expectedDimensions: Pair<Int, Int> = Pair(2, 3)

        //checking that the operation was successful
        for (i in 0 until matrix.getRows())
            for (j in 0 until matrix.getColumns())
                assertEquals(expectedValues[i][j], (matrix - anotherMatrix).data[i][j])
        assertEquals(expectedDimensions, (matrix - anotherMatrix).dimension)

        //checking that the matrix does not change
        assertEquals(true, copyOfMatrix == matrix)
        assertEquals(true, copyOfAnotherMatrix == anotherMatrix)
    }

    @Test
    fun timesWithMatrix() {
        val matrix = Matrix(
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6),
            )
        )

        val copyOfMatrix = getCopyOfMatrix(matrix)

        val anotherMatrix = Matrix(
            arrayOf(
                arrayOf(1),
                arrayOf(2),
                arrayOf(3)
            )
        )
        val copyOfAnotherMatrix = getCopyOfMatrix(anotherMatrix)

        val expectedValues = arrayOf(
            arrayOf(14),
            arrayOf(32),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 1)

        //checking that the operation was successful
        for (i in 0 until (matrix * anotherMatrix).getRows())
            for (j in 0 until (matrix * anotherMatrix).getColumns())
                assertEquals(expectedValues[i][j], (matrix * anotherMatrix).data[i][j])
        assertEquals(expectedDimensions, (matrix * anotherMatrix).dimension)

        //checking that the matrix does not change
        assertEquals(true, copyOfMatrix == matrix)
        assertEquals(true, copyOfAnotherMatrix == anotherMatrix)
    }
    //endregion

    //region Assign operations with another matrix tests
    @Test
    fun assignPlus_WithMatrix() {
        val matrix = Matrix(
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6),
            )
        )

        val copyOfMatrix = getCopyOfMatrix(matrix)

        val anotherMatrix = Matrix(
            arrayOf(
                arrayOf(10, 20, 10),
                arrayOf(30, 10, 10),
            )
        )

        val copyOfAnotherMatrix = getCopyOfMatrix(anotherMatrix)

        val expectedValues = arrayOf(
            arrayOf(11, 22, 13),
            arrayOf(34, 15, 16),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 3)

        matrix += anotherMatrix
        //checking that the operation was successful
        for (i in 0 until matrix.getRows())
            for (j in 0 until matrix.getColumns())
                assertEquals(expectedValues[i][j], matrix.data[i][j])
        assertEquals(expectedDimensions, matrix.dimension)

        //checking that the matrix was change
        assertNotEquals(true, copyOfMatrix == matrix)
        assertEquals(true, copyOfAnotherMatrix == anotherMatrix)
    }

    @Test
    fun assignMinus_WithMatrix() {
        val matrix = Matrix(
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6),
            )
        )
        val copyOfMatrix = getCopyOfMatrix(matrix)

        val anotherMatrix = Matrix(
            arrayOf(
                arrayOf(10, 20, 10),
                arrayOf(30, 10, 10),
            )
        )
        val copyOfAnotherMatrix = getCopyOfMatrix(anotherMatrix)

        val expectedValues = arrayOf(
            arrayOf(-9, -18, -7),
            arrayOf(-26, -5, -4),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 3)

        matrix -= anotherMatrix
        //checking that the operation was successful
        for (i in 0 until matrix.getRows())
            for (j in 0 until matrix.getColumns())
                assertEquals(expectedValues[i][j], matrix.data[i][j])
        assertEquals(expectedDimensions, matrix.dimension)

        //checking that the matrix was change
        assertNotEquals(true, copyOfMatrix == matrix)
        assertEquals(true, copyOfAnotherMatrix == anotherMatrix)
    }

    @Test
    fun assignTimes_WithMatrix() {
        val matrix = Matrix(
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6),
            )
        )
        val copyOfMatrix = getCopyOfMatrix(matrix)

        val anotherMatrix = Matrix(
            arrayOf(
                arrayOf(1),
                arrayOf(2),
                arrayOf(3)
            )
        )
        val copyOfAnotherMatrix = getCopyOfMatrix(anotherMatrix)

        val expectedValues = arrayOf(
            arrayOf(14),
            arrayOf(32),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 1)

        matrix *= anotherMatrix
        //checking that the operation was successful
        for (i in 0 until matrix.getRows())
            for (j in 0 until matrix.getColumns())
                assertEquals(expectedValues[i][j], matrix.data[i][j])

        assertEquals(expectedDimensions, matrix.dimension)

        //checking that the matrix was change
        assertNotEquals(true, copyOfMatrix == matrix)
        assertEquals(true, copyOfAnotherMatrix == anotherMatrix)
    }
    //endregion

    //region Operations with another matrix tests
    @Test
    fun plus_WithScalar() {
        val matrix = Matrix(
            arrayOf(
                arrayOf(10, 20, 10),
                arrayOf(30, 10, 10),
            )
        )
        val copyOfMatrix = getCopyOfMatrix(matrix)

        val expectedValues = arrayOf(
            arrayOf(115, 125, 115),
            arrayOf(135, 115, 115),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 3)

        //checking that the operation was successful
        for (i in 0 until matrix.getRows())
            for (j in 0 until matrix.getColumns())
                assertEquals(expectedValues[i][j], (matrix + 105).data[i][j])
        assertEquals(expectedDimensions, (matrix + 105).dimension)

        //checking that the matrix does not change
        assertEquals(true, copyOfMatrix == matrix)
    }

    @Test
    fun minus_WithScalar() {
        val matrix = Matrix(
            arrayOf(
                arrayOf(10, 20, 10),
                arrayOf(30, 10, 10),
            )
        )
        val copyOfMatrix = getCopyOfMatrix(matrix)

        val expectedValues = arrayOf(
            arrayOf(0, 10, 0),
            arrayOf(20, 0, 0),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 3)

        //checking that the operation was successful
        for (i in 0 until matrix.getRows())
            for (j in 0 until matrix.getColumns())
                assertEquals(expectedValues[i][j], (matrix - 10).data[i][j])
        assertEquals(expectedDimensions, (matrix - 10).dimension)

        //checking that the matrix does not change
        assertEquals(true, copyOfMatrix == matrix)
    }

    @Test
    fun times_WithScalar() {
        val matrix = Matrix(
            arrayOf(
                arrayOf(10, 20, 10),
                arrayOf(30, 10, 10),
            )
        )
        val copyOfMatrix = getCopyOfMatrix(matrix)

        val expectedValues = arrayOf(
            arrayOf(100, 200, 100),
            arrayOf(300, 100, 100),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 3)

        //checking that the operation was successful
        for (i in 0 until matrix.getRows())
            for (j in 0 until matrix.getColumns())
                assertEquals(expectedValues[i][j], (matrix * 10).data[i][j])
        assertEquals(expectedDimensions, (matrix * 10).dimension)

        //checking that the matrix does not change
        assertEquals(true, copyOfMatrix == matrix)
    }
    //endregion

    //region Assign operations with another matrix tests
    @Test
    fun assignPlus_WithScalar() {
        val matrix = Matrix(
            arrayOf(
                arrayOf(10, 20, 10),
                arrayOf(30, 10, 10),
            )

        )
        val copyOfMatrix = getCopyOfMatrix(matrix)

        val expectedValues = arrayOf(
            arrayOf(115, 125, 115),
            arrayOf(135, 115, 115),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 3)

        matrix += 105
        //checking that the operation was successful
        for (i in 0 until matrix.getRows())
            for (j in 0 until matrix.getColumns())
                assertEquals(expectedValues[i][j], (matrix).data[i][j])
        assertEquals(expectedDimensions, (matrix).dimension)

        //checking that the matrix was change
        assertNotEquals(true, copyOfMatrix == matrix)
    }

    @Test
    fun assignMinus_WithScalar() {
        val matrix = Matrix(
            arrayOf(
                arrayOf(10, 20, 10),
                arrayOf(30, 10, 10),
            )
        )
        val copyOfMatrix = getCopyOfMatrix(matrix)

        val expectedValues = arrayOf(
            arrayOf(0, 10, 0),
            arrayOf(20, 0, 0),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 3)

        matrix -= 10
        //checking that the operation was successful
        for (i in 0 until matrix.getRows())
            for (j in 0 until matrix.getColumns())
                assertEquals(expectedValues[i][j], (matrix).data[i][j])
        assertEquals(expectedDimensions, (matrix).dimension)

        //checking that the matrix was change
        assertNotEquals(true, copyOfMatrix == matrix)
    }

    @Test
    fun assignTimes_WithScalar() {
        val matrix = Matrix(
            arrayOf(
                arrayOf(10, 20, 10),
                arrayOf(30, 10, 10),
            )
        )

        val copyOfMatrix = getCopyOfMatrix(matrix)

        val expectedValues = arrayOf(
            arrayOf(100, 200, 100),
            arrayOf(300, 100, 100),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 3)

        matrix *= 10
        //checking that the operation was successful
        for (i in 0 until matrix.getRows())
            for (j in 0 until matrix.getColumns())
                assertEquals(expectedValues[i][j], matrix.data[i][j])

        assertEquals(expectedDimensions, matrix.dimension)

        //checking that the matrix was change
        assertEquals(false, copyOfMatrix == matrix)
    }
    //endregion

    //region Any methods tests
    @Test
    fun isEqual_NotEqual() {
        val matrix = Matrix(
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6),
            )
        )

        val other = Matrix(
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6),
                arrayOf(7, 8, 9),
            )
        )
        assertEquals(false, matrix == other)
    }

    @Test
    fun isEqual_Equal() {
        val matrix = Matrix(
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6),
            )
        )

        val other = Matrix(
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6),
            )
        )
        assertEquals(true, matrix == other)
    }

    @Test
    fun isEqual_NullCase() {
        val matrix = Matrix(
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6),
            )
        )
        val other: Matrix? = null
        assertEquals(false, matrix == other)

    }
    //endregion
}

class MatrixInstrument_Test() {
    @Test(expected = IllegalArgumentException::class)
    fun createMatrixDataOfZero_NegativeFirstParameter() {
        val actual = MatrixInstrument.createMatrixDataOfZero(-666, 0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun createMatrixDataOfZero_NegativeSecondParameter() {
        val actual = MatrixInstrument.createMatrixDataOfZero(0, -666)
    }

    @Test(expected = IllegalArgumentException::class)
    fun createMatrixDataOfZero_NegativeBothParameters() {
        val actual = MatrixInstrument.createMatrixDataOfZero(-666, -666)
    }

    @Test
    fun createMatrixDataOfZero_EmptyResult() {
        val actual = MatrixInstrument.createMatrixDataOfZero(0, 0)
        val expected =
            arrayOf<Array<Int>>()

        assertNotEquals(expected, actual)
    }

    @Test
    fun createMatrixDataOfZero_CorrectResult() {
        val actual = MatrixInstrument.createMatrixDataOfZero(3, 3)
        val expected =
            arrayOf(
                arrayOf(0, 0, 0),
                arrayOf(0, 0, 0),
                arrayOf(0, 0, 0),
            )

        assertNotEquals(actual, expected)
    }

    @Test
    fun getDeepCopyOfMatrixData_ChangeRef() {
        val actual = MatrixInstrument.createMatrixDataOfZero(3, 3)
        val expected =
            arrayOf(
                arrayOf(0, 0, 0),
                arrayOf(0, 0, 0),
                arrayOf(0, 0, 0),
            )

        expected[0][0] = 9
        expected[1][1] = 9
        expected[2][2] = 9

        assertEquals(0, actual[0][0])
        assertEquals(0, actual[1][1])
        assertEquals(0, actual[2][2])
    }
}