package Two_Pointers

class _27 {

    fun removeElement(nums: IntArray, `val`: Int): Int {
        var indexRight = nums.size - 1

        nums.forEachIndexed { index, i ->
            if (i == `val`) {
                while (index < indexRight && nums[indexRight] == `val`) {
                    indexRight--
                }
                if (index == indexRight) {
                    return indexRight
                } else {
                    nums[index] = nums[indexRight]
                    nums[indexRight] = `val`
                }
            }
        }
        return indexRight + 1
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(_27().removeElement(intArrayOf(4, 5, 5), 3))
        }
    }
}