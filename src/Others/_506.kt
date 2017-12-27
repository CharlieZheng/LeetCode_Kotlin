package Others

class _506 {
    class C(val i: Int, val rank: Int, var str: String = "")

    fun findRelativeRanks(nums: IntArray): Array<String> {
        val cArray = Array<C>(nums.size, { it -> C(it, nums[it]) })
        cArray.sortByDescending { it.rank }
        if (cArray.isNotEmpty()) cArray[0].str = "Gold Medal"
        if (cArray.size > 1) cArray[1].str = "Silver Medal"
        if (cArray.size > 2) cArray[2].str = "Bronze Medal"
        var i = 0
        while (i < cArray.size) {
            if (i < 3) {
                i++
                continue
            }
            cArray[i].str = (i + 1).toString()
            i++
        }
        cArray.sortBy { it.i }
        return cArray.map { it.str }.toTypedArray()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val array = _506().findRelativeRanks(intArrayOf())
            array.forEach { print(it + "\t") }
        }
    }
}