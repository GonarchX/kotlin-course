package lab4

class MatrixInstrument {
    companion object{
        fun createMutableListWithLists(rows: Int, columns: Int ): MutableList<MutableList<Double>>{
            if (rows < 0 || columns < 0)
                throw IllegalArgumentException("Number of rows or columns can't be negative!")

            // List of lists
            var requiredList: MutableList<MutableList<Double>> =
                mutableListOf<MutableList<Double>>()

            for (i in 0 until rows)
                requiredList.add(MutableList<Double>(columns) {index -> 0.0})
            return  requiredList
        }

        fun getCopyOfMatrix(matrix: Matrix): Matrix{
            var copyValues = createMutableListWithLists(matrix.getRows(), matrix.getColumns())

            for (i in 0 until matrix.getRows())
                for (j in 0 until  matrix.getColumns())
                    copyValues[i][j] = matrix[i,j]

            return Matrix(copyValues)
        }
    }
}