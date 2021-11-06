import lab4.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import lab4.MatrixInstrument.Companion.getCopyOfMatrix

class Matrix_Test() {

    //region Operations with another matrix tests
    @Test
    fun plus_WithMatrix() {
        var temp =
            mutableListOf(
                mutableListOf(1.0, 2.0, 3.0),
                mutableListOf(4.0, 5.0, 6.0),
            )

        val matrix = Matrix(temp)
        val copyOfMatrix = getCopyOfMatrix(matrix)

        temp =
            mutableListOf(
                mutableListOf(10.0, 20.0, 10.0),
                mutableListOf(30.0, 10.0, 10.0),
            )

        val anotherMatrix = Matrix(temp)
        val copyOfAnotherMatrix = getCopyOfMatrix(anotherMatrix)

        val expectedValues = mutableListOf(
            mutableListOf(11.0, 22.0, 13.0),
            mutableListOf(34.0, 15.0, 16.0),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 3)

        //checking that the operation was successful
        assertEquals(expectedValues, (matrix + anotherMatrix).values)
        assertEquals(expectedDimensions, (matrix + anotherMatrix).dimension)

        //checking that the matrix does not change
        assertEquals(true, copyOfMatrix == matrix)
        assertEquals(true, copyOfAnotherMatrix == anotherMatrix)
    }

    @Test
    fun minusWithMatrix() {
        var temp =
            mutableListOf(
                mutableListOf(1.0, 2.0, 3.0),
                mutableListOf(4.0, 5.0, 6.0),
            )

        val matrix = Matrix(temp)
        val copyOfMatrix = getCopyOfMatrix(matrix)

        temp =
            mutableListOf(
                mutableListOf(10.0, 20.0, 10.0),
                mutableListOf(30.0, 10.0, 10.0),
            )

        val anotherMatrix = Matrix(temp)
        val copyOfAnotherMatrix = getCopyOfMatrix(anotherMatrix)

        val expectedValues = mutableListOf(
            mutableListOf(-9.0, -18.0, -7.0),
            mutableListOf(-26.0, -5.0, -4.0),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 3)

        //checking that the operation was successful
        assertEquals(expectedValues, (matrix - anotherMatrix).values)
        assertEquals(expectedDimensions, (matrix - anotherMatrix).dimension)

        //checking that the matrix does not change
        assertEquals(true, copyOfMatrix == matrix)
        assertEquals(true, copyOfAnotherMatrix == anotherMatrix)
    }

    @Test
    fun timesWithMatrix() {
        var temp =
            mutableListOf(
                mutableListOf(1.0, 2.0, 3.0),
                mutableListOf(4.0, 5.0, 6.0),
            )

        val matrix = Matrix(temp)
        val copyOfMatrix = getCopyOfMatrix(matrix)

        temp =
            mutableListOf(
                mutableListOf(1.0),
                mutableListOf(2.0),
                mutableListOf(3.0)
            )

        val anotherMatrix = Matrix(temp)
        val copyOfAnotherMatrix = getCopyOfMatrix(anotherMatrix)

        val expectedValues = mutableListOf(
            mutableListOf(14.0),
            mutableListOf(32.0),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 1)

        //checking that the operation was successful
        assertEquals(expectedValues, (matrix * anotherMatrix).values)
        assertEquals(expectedDimensions, (matrix * anotherMatrix).dimension)

        //checking that the matrix does not change
        assertEquals(true, copyOfMatrix == matrix)
        assertEquals(true, copyOfAnotherMatrix == anotherMatrix)
    }
    //endregion

    //region Assign operations with another matrix tests
    @Test
    fun assignPlus_WithMatrix() {
        var temp =
            mutableListOf(
                mutableListOf(1.0, 2.0, 3.0),
                mutableListOf(4.0, 5.0, 6.0),
            )

        val matrix = Matrix(temp)
        val copyOfMatrix = getCopyOfMatrix(matrix)

        temp =
            mutableListOf(
                mutableListOf(10.0, 20.0, 10.0),
                mutableListOf(30.0, 10.0, 10.0),
            )

        val anotherMatrix = Matrix(temp)
        val copyOfAnotherMatrix = getCopyOfMatrix(anotherMatrix)

        val expectedValues = mutableListOf(
            mutableListOf(11.0, 22.0, 13.0),
            mutableListOf(34.0, 15.0, 16.0),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 3)

        matrix += anotherMatrix
        //checking that the operation was successful
        assertEquals(expectedValues, matrix.values)
        assertEquals(expectedDimensions, matrix.dimension)

        //checking that the matrix was change
        assertNotEquals(true, copyOfMatrix == matrix)
        assertEquals(true, copyOfAnotherMatrix == anotherMatrix)
    }

    @Test
    fun assignMinus_WithMatrix() {
        var temp =
                mutableListOf(
                mutableListOf(1.0, 2.0, 3.0),
            mutableListOf(4.0, 5.0, 6.0),
        )

        val matrix = Matrix(temp)
        val copyOfMatrix = getCopyOfMatrix(matrix)

        temp =
            mutableListOf(
                mutableListOf(10.0, 20.0, 10.0),
                mutableListOf(30.0, 10.0, 10.0),
            )

        val anotherMatrix = Matrix(temp)
        val copyOfAnotherMatrix = getCopyOfMatrix(anotherMatrix)

        val expectedValues = mutableListOf(
            mutableListOf(-9.0, -18.0, -7.0),
            mutableListOf(-26.0, -5.0, -4.0),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 3)

        matrix -= anotherMatrix
        //checking that the operation was successful
        assertEquals(expectedValues, matrix.values)
        assertEquals(expectedDimensions, matrix.dimension)

        //checking that the matrix was change
        assertNotEquals(true, copyOfMatrix == matrix)
        assertEquals(true, copyOfAnotherMatrix == anotherMatrix)
    }

    @Test
    fun assignTimes_WithMatrix() {
        var temp =
            mutableListOf(
                mutableListOf(1.0, 2.0, 3.0),
                mutableListOf(4.0, 5.0, 6.0),
            )

        val matrix = Matrix(temp)
        val copyOfMatrix = getCopyOfMatrix(matrix)

        temp =
            mutableListOf(
                mutableListOf(1.0),
                mutableListOf(2.0),
                mutableListOf(3.0)
            )

        val anotherMatrix = Matrix(temp)
        val copyOfAnotherMatrix = getCopyOfMatrix(anotherMatrix)

        val expectedValues = mutableListOf(
            mutableListOf(14.0),
            mutableListOf(32.0),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 1)

        matrix *= anotherMatrix
        //checking that the operation was successful
        assertEquals(expectedValues, matrix.values)
        assertEquals(expectedDimensions, matrix.dimension)

        //checking that the matrix was change
        assertNotEquals(true, copyOfMatrix == matrix)
        assertEquals(true, copyOfAnotherMatrix == anotherMatrix)
    }
    //endregion

    //region Operations with another matrix tests
    @Test
    fun plus_WithScalar() {
        val temp =
            mutableListOf(
                mutableListOf(10.0, 20.0, 10.0),
                mutableListOf(30.0, 10.0, 10.0),
            )

        val matrix = Matrix(temp)
        val copyOfMatrix = getCopyOfMatrix(matrix)

        val expectedValues = mutableListOf(
            mutableListOf(20.05, 30.05, 20.05),
            mutableListOf(40.05, 20.05, 20.05),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 3)

        //checking that the operation was successful
        assertEquals(expectedValues, (matrix + 10.05).values)
        assertEquals(expectedDimensions, (matrix + 10.05).dimension)

        //checking that the matrix does not change
        assertEquals(true, copyOfMatrix == matrix)
    }

    @Test
    fun minus_WithScalar() {
         val temp =
            mutableListOf(
                mutableListOf(10.0, 20.0, 10.0),
                mutableListOf(30.0, 10.0, 10.0),
            )

        val matrix = Matrix(temp)
        val copyOfMatrix = getCopyOfMatrix(matrix)

        val expectedValues = mutableListOf(
            mutableListOf(0.0, 10.0, 0.0),
            mutableListOf(20.0, 0.0, 0.0),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 3)

        //checking that the operation was successful
        assertEquals(expectedValues, (matrix - 10.0).values)
        assertEquals(expectedDimensions, (matrix - 10.0).dimension)

        //checking that the matrix does not change
        assertEquals(true, copyOfMatrix == matrix)
    }

    @Test
    fun times_WithScalar() {
        val temp =
            mutableListOf(
                mutableListOf(10.0, 20.0, 10.0),
                mutableListOf(30.0, 10.0, 10.0),
            )

        val matrix = Matrix(temp)
        val copyOfMatrix = getCopyOfMatrix(matrix)

        val expectedValues = mutableListOf(
            mutableListOf(100.0, 200.0, 100.0),
            mutableListOf(300.0, 100.0, 100.0),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 3)

        //checking that the operation was successful
        assertEquals(expectedValues, (matrix * 10.0).values)
        assertEquals(expectedDimensions, (matrix * 10.0).dimension)

        //checking that the matrix does not change
        assertEquals(true, copyOfMatrix == matrix)
    }
    //endregion

    //region Assign operations with another matrix tests
    @Test
    fun assignPlus_WithScalar() {
        val temp =
            mutableListOf(
                mutableListOf(10.0, 20.0, 10.0),
                mutableListOf(30.0, 10.0, 10.0),
            )

        val matrix = Matrix(temp)
        val copyOfMatrix = getCopyOfMatrix(matrix)

        val expectedValues = mutableListOf(
            mutableListOf(20.05, 30.05, 20.05),
            mutableListOf(40.05, 20.05, 20.05),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 3)

        matrix += 10.05
        //checking that the operation was successful
        assertEquals(expectedValues, (matrix).values)
        assertEquals(expectedDimensions, (matrix).dimension)

        //checking that the matrix was change
        assertNotEquals(true, copyOfMatrix == matrix)
    }

    @Test
    fun assignMinus_WithScalar() {
        val temp =
            mutableListOf(
                mutableListOf(10.0, 20.0, 10.0),
                mutableListOf(30.0, 10.0, 10.0),
            )

        val matrix = Matrix(temp)
        val copyOfMatrix = getCopyOfMatrix(matrix)

        val expectedValues = mutableListOf(
            mutableListOf(0.0, 10.0, 0.0),
            mutableListOf(20.0, 0.0, 0.0),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 3)

        matrix -= 10.0
        //checking that the operation was successful
        assertEquals(expectedValues, (matrix).values)
        assertEquals(expectedDimensions, (matrix).dimension)

        //checking that the matrix was change
        assertNotEquals(true, copyOfMatrix == matrix)
    }

    @Test
    fun assignTimes_WithScalar() {
        val temp =
            mutableListOf(
                mutableListOf(10.0, 20.0, 10.0),
                mutableListOf(30.0, 10.0, 10.0),
            )

        val matrix = Matrix(temp)
        val copyOfMatrix = getCopyOfMatrix(matrix)

        val expectedValues = mutableListOf(
            mutableListOf(100.0, 200.0, 100.0),
            mutableListOf(300.0, 100.0, 100.0),
        )
        val expectedDimensions: Pair<Int, Int> = Pair(2, 3)

        //checking that the operation was successful
        assertEquals(expectedValues, (matrix * 10.0).values)
        assertEquals(expectedDimensions, (matrix * 10.0).dimension)

        //checking that the matrix was change
        assertNotEquals(true, copyOfMatrix == matrix)
    }
    //endregion

    //region Any methods tests
    @Test
    fun isEqual_NotEqual() {
        var temp =
            mutableListOf(
                mutableListOf(1.0, 2.0, 3.0),
                mutableListOf(4.0, 5.0, 6.0),
            )
        val matrix = Matrix(temp)

        temp = mutableListOf(
            mutableListOf(1.0, 2.0, 3.0),
            mutableListOf(4.0, 5.0, 6.0),
            mutableListOf(7.0, 8.0, 9.0),
        )
        val other = Matrix(temp)
        assertEquals(false, matrix == other)
    }

    @Test
    fun isEqual_Equal() {
        val temp =
            mutableListOf(
                mutableListOf(1.0, 2.0, 3.0),
                mutableListOf(4.0, 5.0, 6.0),
            )
        val matrix = Matrix(temp)
        val other = Matrix(temp)
        assertEquals(true, matrix == other)
    }

    @Test
    fun isEqual_NullCase() {
        val temp =
            mutableListOf(
                mutableListOf(1.0, 2.0, 3.0),
                mutableListOf(4.0, 5.0, 6.0),
            )
        val matrix = Matrix(temp)
        val other: Matrix? = null
        assertEquals(false, matrix == other)

    }
    //endregion
}

class MatrixInstrument_Test() {
    @Test(expected = IllegalArgumentException::class)
    fun createMutableListWithLists_NegativeFirstParameter() {
        val actual = MatrixInstrument.createMutableListWithLists(-666, 0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun createMutableListWithLists_NegativeSecondParameter() {
        val actual = MatrixInstrument.createMutableListWithLists(0, -666)
    }

    @Test(expected = IllegalArgumentException::class)
    fun createMutableListWithLists_NegativeBothParameters() {
        val actual = MatrixInstrument.createMutableListWithLists(-666, -666)
    }

    @Test
    fun createMutableListWithLists_EmptyResult() {
        val actual = MatrixInstrument.createMutableListWithLists(0, 0)
        val expected =
            mutableListOf<MutableList<Double>>()

        assertEquals(expected, actual)
    }

    @Test
    fun createMutableListWithLists_CorrectResult() {
        val actual = MatrixInstrument.createMutableListWithLists(3, 3)
        val expected =
            mutableListOf(
                mutableListOf(0.0, 0.0, 0.0),
                mutableListOf(0.0, 0.0, 0.0),
                mutableListOf(0.0, 0.0, 0.0),
            )
        assertEquals(actual, expected)
    }
}