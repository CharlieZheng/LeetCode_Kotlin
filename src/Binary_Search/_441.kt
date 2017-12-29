package Binary_Search

class _441 {
    fun arrangeCoins(n: Int): Int {
        var i = 0
        var m = n
        while (m > 0) {
            m = m - (++i)
        }
        if (i == 0) return 0
        return if (m == 0) i else i - 1
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(_441().arrangeCoins(78))
        }
    }
}