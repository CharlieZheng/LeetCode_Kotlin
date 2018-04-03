package Array

class _219 {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        if (k <= 0) return false
        val size = nums.size
        val left = ArrayList<Int>()
        nums.forEachIndexed { index, i ->
            var kk = k - 1
            if (index + k < size) {
                while (kk >= 0) {
                    if (nums[index] == nums[index + k - kk]) return true
                    kk--
                }
            } else {
                left.forEach { if (nums[index] == it) return true }
                left.add(i)
            }
        }


        return false
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {


            println(_219().containsNearbyDuplicate(intArrayOf(2, 2), 2))

        }
    }
}