package Array

class _581 {
    fun findUnsortedSubarray(nums: IntArray): Int {
        val size = nums.size
        if (size <= 1) return 0
        var left = nums[0]
        var found = false
        var breakAll = false
        var leftIndex = 0
        for (i in 1 until size) {
            if (left > nums[i]) {
                for (j in 0 until i) {
                    if (nums[j] > nums[i]) {
                        leftIndex = j
                        found = true
                        if (j - 1 >= 0) left = nums[j - 1]
                        else breakAll = true
                        break
                    }
                }
                if (breakAll) break
            } else if (!found)
                left = nums[i]
        }
        if (!found) return 0
        found = false
        breakAll = false
        var right = nums[size - 1]
        var rightIndex = size - 1
        for (i in size - 1 downTo 0) {
            if (right < nums[i]) {
                for (j in size - 1 downTo i) {
                    if (nums[j] < nums[i]) {
                        rightIndex = j
                        found = true
                        if (j + 1 <= size - 1) right = nums[j + 1]
                        else breakAll = true
                        break
                    }
                }
                if (breakAll) break
            } else if (!found)
                right = nums[i]
        }
        return rightIndex - leftIndex + 1
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = _581()
            println(o.findUnsortedSubarray(intArrayOf(1, 3, 5, 4, 2)))
        }
    }
}