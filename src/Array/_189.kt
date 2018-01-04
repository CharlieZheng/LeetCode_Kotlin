package Array

class _189 {
    fun rotate(nums: IntArray, k: Int) {
        val newK = k % nums.size
        if (newK >= nums.size) return
        val after = nums.copyOfRange(nums.size - newK, nums.size)
        for (i in 0 until nums.size - newK) {
            nums[nums.size - 1 - i] = nums[nums.size - newK - 1 - i]
        }
        for (i in 0 until newK) {
            nums[i] = after[i]
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = _189()
            val temp = intArrayOf(1, 4, 3, 3, 4, 2, 4, 6, 7, 8, 4, 2, 1, 7, 8, 5, 4)
            o.rotate(temp, 19)
            for (i in 0 until temp.size) {
                print(temp[i].toString() + "\t")
            }
        }
    }
}