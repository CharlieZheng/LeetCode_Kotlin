package Array

class _414 {

    fun thirdMax(nums: IntArray): Int {
        var big: Int? = null
        var mid: Int? = null
        var small: Int? = null
        nums.forEach {
            if (it == big || it == mid || it == small) return@forEach
            if (big == null || big?.toInt() ?: Int.MIN_VALUE < it) {
                small = mid
                mid = big
                big = it
            } else if (mid == null || mid?.toInt() ?: Int.MIN_VALUE < it) {
                small = mid
                mid = it
            } else if (small == null || small?.toInt() ?: Int.MIN_VALUE < it)
                small = it
        }
        return small ?: big ?: 0
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(_414().thirdMax(intArrayOf(4, 3, 3, 1)))
        }
    }
}