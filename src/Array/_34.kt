package Array

class _34 {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val result = IntArray(2, { -1 })
        val size = nums.size
        var b = false
        for (i in 0 until size) {
            if (b) {
                if (target != nums[i]) {
                    result[1] = i - 1
                    break
                }
            } else {
                if (target == nums[i]) {
                    result[0] = i
                    b = true
                }
            }

        }
        if (result[0] != -1 && result[1] == -1) result[1] = size - 1
        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val cgf = _34().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 10)
            cgf.forEach {
                print(it.toString() + "\t")
            }
        }
    }
}