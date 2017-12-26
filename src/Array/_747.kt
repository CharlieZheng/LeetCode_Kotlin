package Array

class _747 {
    fun dominantIndex(nums: IntArray): Int {
        var result = -1
        var max = Int.MIN_VALUE
        var secondMax = Int.MIN_VALUE
        for (i in 0 until nums.size) {
            if (nums[i] > secondMax) {
                secondMax = nums[i]
                if (nums[i] > max) {
                    secondMax = max
                    max = nums[i]
                    result = i
                }
            }
        }
        if (secondMax == max || max < secondMax * 2) return -1
        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = _747()
            print(o.dominantIndex(intArrayOf(0, 0, 3, 2)))
        }
    }
}