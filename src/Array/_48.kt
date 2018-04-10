package Array

class _48 {
    fun rotate(matrix: Array<IntArray>): Unit {
        val rowSize = matrix.size
        if (rowSize == 0) return
        val colSize = matrix[0].size

        for (i in 0 until rowSize) {
            for (j in 0 until colSize) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }
        /*for (i  in 0 until rowSize) {
            for (j in 0 until colSize/2 ) {
                val temp = matrix[i][j]
                matrix[i][j] =matrix[i][colSize-1-j]
                matrix[i][colSize-1-j]=temp
            }
        }*/
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val temp = Array(3, { intArrayOf(3, 4) })
            temp[0] = intArrayOf(3, 4, 2)
            temp[1] = intArrayOf(3, 4, 2)
            temp[2] = intArrayOf(3, 4, 2)
            _48().rotate(temp)
            val rowSize = temp.size
            val colSize = temp[0].size
            for (i in 0 until rowSize) {
                for (j in 0 until colSize) {
                    print(temp[i][j].toString() + "\t")
                }
                println()
            }
        }
    }

    /* 3, 5, 6, 7
     6, 7, 9, 0
     a, 7, 3, 9
     9, 1, 6, 9


     3, 6, a, 9
     5, 7, 7, 1
     6, 9, 3, 6
     7, 0, 9, 9*/
}