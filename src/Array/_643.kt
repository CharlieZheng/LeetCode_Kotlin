package Array

class _643 {


    fun findMaxAverage(nums: IntArray, k: Int): Double {
        val size = nums.size
        var maxSum = 0
        if (size == k) {

            nums.forEach {
                maxSum += it
            }
            return maxSum / k.toDouble()
        }
        var sum = 0
        nums.forEachIndexed { index, i ->
            sum = 0
            if (index <= size - k) {
                for (i2 in index until index + k) {
                    sum += nums[i2]
                }
                if (sum > maxSum) {
                    maxSum = sum
                }

            }
        }
        return maxSum / k.toDouble()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {


            println(_643().findMaxAverage(intArrayOf(5), 1))
        }
    }
}