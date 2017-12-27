package Array

class _661 {
    fun imageSmoother(M: Array<IntArray>): Array<IntArray> {
        val N = Array<IntArray>(M.size, { it -> IntArray(M[it].size, { itt -> M[it][itt] }) })
        for (i in 0 until M.size) {
            for (j in 0 until M[i].size) {
                var _1: Int? = null
                if (i - 1 >= 0 && j - 1 >= 0) _1 = M[i - 1][j - 1]

                var _2: Int? = null
                if (j - 1 >= 0) _2 = M[i][j - 1]
                var _3: Int? = null
                if (i + 1 < M.size && j - 1 >= 0) _3 = M[i + 1][j - 1]
                var _4: Int? = null
                if (i - 1 >= 0) _4 = M[i - 1][j]
                val _5: Int? = M[i][j]
                var _6: Int? = null
                if (i + 1 < M.size) _6 = M[i + 1][j]
                var _7: Int? = null
                if (i - 1 >= 0 && j + 1 < M[i - 1].size) _7 = M[i - 1][j + 1]
                var _8: Int? = null
                if (j + 1 < M[i].size) _8 = M[i][j + 1]
                var _9: Int? = null
                if (i + 1 < M.size && j + 1 < M[i + 1].size) _9 = M[i + 1][j + 1]

                var cnt = 0.0
                if (_1 != null) cnt++
                if (_2 != null) cnt++
                if (_3 != null) cnt++
                if (_4 != null) cnt++
                if (_5 != null) cnt++
                if (_6 != null) cnt++
                if (_7 != null) cnt++
                if (_8 != null) cnt++
                if (_9 != null) cnt++
                N[i][j] = Math.floor(((_1 ?: 0) + (_2 ?: 0) + (_3 ?: 0) + (_4 ?: 0) + (_5 ?: 0) + (_6 ?: 0) + (_7 ?: 0) + (_8 ?: 0) + (_9 ?: 0)) / cnt).toInt()
            }
        }
        return N
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val a = arrayOf<IntArray>(intArrayOf(1, 1, 1), intArrayOf(1, 0, 1), intArrayOf(1, 1, 1))
            val temp = _661().imageSmoother(a)
            for (i in 0 until temp.size) {
                for (j in 0 until temp[i].size) {
                    print(temp[i][j].toString() + "\t")
                }
                println()
            }
        }
    }
}