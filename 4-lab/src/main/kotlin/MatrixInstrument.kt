package lab4

class MatrixInstrument {
    companion object{
        fun createMatrixDataOfZero(rows: Int, columns: Int): Array<Array<Int>> {
            if (rows < 0 || columns < 0)
                throw IllegalArgumentException("Number of rows or columns can't be negative!")

            return Array(rows) { Array(columns) { 0 } }
        }

        fun getCopyOfMatrix(inputMatrix: Matrix): Matrix = Matrix(getDeepCopyOfMatrixData(inputMatrix.data))

        fun getDeepCopyOfMatrixData(inputArray: Array<Array<Int>>): Array<Array<Int>> =
            inputArray.clone().map { it.clone() }.toTypedArray()
    }
}