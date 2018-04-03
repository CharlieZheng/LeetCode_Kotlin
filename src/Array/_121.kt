package Array

class _121 {
    fun maxProfit(prices: IntArray): Int {
        val size = prices.size
        var max = 0
        for (i in size - 1 downTo 0) {
            for (j in 0 until i) {
                val item = prices[i] - prices[j]
                if (max < item) {
                    max = item
                }
            }
        }
        return max
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(_121().maxProfit(intArrayOf(7, 6, 4, 3, 1)))
        }
    }
}