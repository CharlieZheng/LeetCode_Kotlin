package Array

class _122 {
    fun maxProfit(prices: IntArray): Int {
        val size = prices.size
        var result = 0
        for (i in 0 until size - 1) {
            val item = prices[i + 1] - prices[i]
            if (item > 0) {
                result += item
            }
        }
        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(_122().maxProfit(intArrayOf(7, 6, 4, 3, 1)))
        }
    }
}