package Backtracking

class _22 {
    private fun b(string: String): Boolean {
        val size = string.length
        var cnt = 0
        for (i in 0 until size) {
            if (string[i] == '(') {
                cnt++
                if (cnt > 1) return false
            } else if (string[i] == ')') {
                cnt--
                if (cnt < 0) return false
            }
        }
        return true
    }

    fun generateParenthesis(n: Int): List<String> {
        val result = ArrayList<String>()
        if (n < 1) return result
        val temp = "()"
        result.add(temp)
        var cnt = 0
        val nextResult = ArrayList<String>()
        while (cnt++ < n - 1) {
            nextResult.clear()
            result.forEach {

                if (b(it)) {
                    nextResult.add("(" + it + ")")
                    nextResult.add(it + "()")
                } else {
                    nextResult.add("(" + it + ")")
                    nextResult.add("()" + it)
                    nextResult.add(it + "()")
                }
            }
            result.clear()
            result.addAll(nextResult)
        }

        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val cgf = _22().generateParenthesis(4)
            cgf.forEach {
                println(it)
            }
        }
    }


}