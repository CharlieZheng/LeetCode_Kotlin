package Backtracking

class _17 {
    private val c2 = charArrayOf('a', 'b', 'c')
    private val c3 = charArrayOf('d', 'e', 'f')
    private val c4 = charArrayOf('g', 'h', 'i')
    private val c5 = charArrayOf('j', 'k', 'l')
    private val c6 = charArrayOf('m', 'n', 'o')
    private val c7 = charArrayOf('p', 'q', 'r', 's')
    private val c8 = charArrayOf('t', 'u', 'v')
    private val c9 = charArrayOf('w', 'x', 'y', 'z')
    private val c = arrayOf(c2, c3, c4, c5, c6, c7, c8, c9)
    fun letterCombinations(digits: String): List<String> {
        var list = ArrayList<String>()
        if (digits.length <= 0) return list
        val i = digits[0].toInt() - 50
        if (i < 0 || i >= c.size) return list
        c[i].forEach {
            list.add(it.toString())
        }
        val temp = ArrayList<String>()
        digits.forEachIndexed { index, d ->
            if (index > 0) {
                val i_ = d.toInt() - 48
                if (i_ > 1 && i_ < 10) {

                    temp.clear()
                    temp.addAll(list)
                    c[i_ - 2].forEach {
                        val itt = it
                        list.forEach {
                            temp.add(it + itt)
                        }
                    }
                    list.clear()
                    list.addAll(temp)
                }
            }
        }
        list = list.filter { it.length == digits.length } as ArrayList<String>
        return list
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val cgf = _17()
            val list = cgf.letterCombinations("1234")
            list.forEach { print(it + "\t") }
        }
    }


}