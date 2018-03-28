package Two_Pointers

class _11 {

    fun maxArea(height: IntArray): Int {
        val size = height.size
        if (size <= 1) return 0
        val temp = arrayOfNulls<Char>(size)
        for (i in 0 until size) {
            temp[i] = if (i <= 1) '1' else '0'
        }
        val c_size_2 = size * (size - 1) / 2 // c size选2
        val combinationList = arrayOfNulls<kotlin.Array<Char?>>(c_size_2)
        combinationList[0] = temp.copyOf()
        var first10 = 0
        var indexBeforeFirst10 = 0
        var indexOfTemp2 = 1
        while (!(temp[size - 1] == '1' && temp[size - 2] == '1')) {
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
                if (c == '1' && index != indexBeforeFirst10) {
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
        var maxArea = 0
        var itemArea = 0
        var width = 0
        var heightTemp = Int.MAX_VALUE
        combinationList.forEach {
            width = 0
            heightTemp = Int.MAX_VALUE
            it?.forEachIndexed { index, c ->
                if (c == '1') {
                    width = index - width
                    heightTemp = if (height[index] < heightTemp) height[index] else heightTemp
                }
            }
            itemArea = width * heightTemp
            maxArea = if (itemArea > maxArea) itemArea else maxArea
        }
        return maxArea
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(_11().maxArea(intArrayOf(4, 3, 5)))
        }
    }
}