package Two_Pointers

class _15 {
    private fun factorial(num: Int): Int {
        var numTemp = num
        var result = 1
        while (numTemp >= 1) {
            result *= numTemp
            numTemp--
        }
        return result
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        val size = nums.size
        if (size < 3) return result
        val temp = arrayOfNulls<Char>(size)
        for (i in 0 until size) {
            temp[i] = if (i <= 2) '1' else '0'
        }
        val c_size_3 = factorial(size) / (factorial(3) * factorial(2)) // c size选3
        val combinationList = arrayOfNulls<kotlin.Array<Char?>>(c_size_3)
        combinationList[0] = temp.copyOf()
        var first10 = 0
        var indexBeforeFirst10 = 0
        var indexOfTemp2 = 1
        while (!(temp[size - 1] == '1' && temp[size - 2] == '1' && temp[size - 3] == '1')) {
            first10 = 0
            while (!(temp[first10] == '1' && temp[first10 + 1] == '0')) {
                if (first10 >= size - 2) break
                first10++
            }
            if (first10 >= size - 1) continue // 这种情况不可能发生，除非所有的1都靠右了。而如果所有的1都靠右了，则不会进入循环体
            temp[first10] = '0'
            temp[first10 + 1] = '1'
            indexBeforeFirst10 = 0
            temp.forEachIndexed { index, c ->
                if (index >= first10) return@forEachIndexed
                if (c == '1') {
                    if (index == indexBeforeFirst10) {
                        indexBeforeFirst10++
                    } else {
                        temp[index] = '0'
                        temp[indexBeforeFirst10++] = '1'
                    }
                }
            }
            combinationList[indexOfTemp2++] = temp.copyOf()
        }
        val combinationListFiltered: List<Array<Char?>?>
        combinationListFiltered = combinationList.filter {
            var itemSum = 0
            it?.forEachIndexed { index, c ->
                if (c == '1') {
                    itemSum += nums[index]
                }
            }
            return@filter itemSum == 0
        }
        var item: ArrayList<Int>
        combinationListFiltered.forEach {
            item = ArrayList<Int>()
            it?.forEachIndexed { index, c ->
                if (c == '1') {
                    item.add(nums[index])
                }
            }
            item.sort()
            var contain = false
            result.forEach {
                var same = true
                val size = item.size
                if (size <= 0) same = false
                for (index in 0..(size - 1)) {
                    if (it[index] != item[index]) same = false
                }
                if (same) {
                    contain = true
                    return@forEach
                }
            }
            if (!contain && !item.isEmpty())
                result.add(item)
        }
        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(_15().threeSum(intArrayOf(-1, 0, 1, 2, -1, -4, 6, 4, 3, 32, -6, 4, 3, 2, 0, 5, 4, 3, 2, 3, 1)))
        }
    }
}