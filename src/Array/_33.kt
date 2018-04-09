package Array

class _33 {
    fun search(nums: IntArray, target: Int): Int {

        val size = nums.size
        var index = -1
        var indexEqual = -1
        var found = false
        var foundEqual = false
        for (i in 0 until size - 1) {

            if (found && foundEqual) break
            if (!foundEqual)
                if (nums[i] == target) {
                    indexEqual = i
                    foundEqual = true
                }
            if (!found) {
                if (nums[i] > nums[i + 1]) {
                    index = i
                    found = true
                }
            }
        }

        if (!foundEqual) return -1
        return if (!found) indexEqual
        else if (index < indexEqual) index + indexEqual else index - indexEqual
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(_33().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
        }
    }
}