package Two_Pointers

import java.lang.Exception

/**
 * 这个解法的解题思路如下：
 * 1. 在 [0, size-1] 这个区间选出第一和第二高的柱子的 index，区间为 [a, b]（其中 a >= 0，b <= size-1），算出该区间的水量
 * 2. 把 [0, size-1] 的区间缩小为 [0, a] 和 [b, size-1] 两部分，代码中的 end 方法就是依次找出这些未被计算的小区间
 * 3. 把每个小区间的水量加起来得到整个区间的水量
 */
class _42 {
    data class Pair(val small: Data, val big: Data)
    data class Data(var index: Int, var v: Int)
    data class Interval(val left: Int, val right: Int)

    private val secondaryMaxList = ArrayList<Data>()
    private val maxList = ArrayList<Data>()
    fun trap(height: IntArray): Int {
        if (height.isEmpty() || height.size <= 1) return 0
        val pairList = ArrayList<Pair>()
        initPairList0(pairList, height)
        var result = 0
        pairList.forEach {
            var extras = 0
            val left = if (it.small.index < it.big.index) it.small.index else it.big.index
            val right = if (it.small.index > it.big.index) it.small.index else it.big.index
            for (i in left + 1 until right) {
                extras += height[i]
            }

            result += (if (it.small.v < it.big.v) it.small.v else it.big.v) * (Math.abs(it.big.index - it.small.index) - 1) - extras
        }

        return result
    }

    private fun initPairList0(pairList: ArrayList<Pair>, height: IntArray) {
        val indexList = ArrayList<Int>()
        var interval: Interval? = end(indexList, height.size)
        while (interval != null) {
            initPairList(pairList, indexList, height, interval.left, interval.right)
            interval = end(indexList, height.size)
        }
    }

    private fun end(indexList: ArrayList<Int>, size: Int): Interval? {
        var lastIndex = -1
        for (i in 0 until indexList.size) {
            if (lastIndex > indexList[i])
                throw Exception("未排序")
            lastIndex = indexList[i]
        }
        if (indexList.size % 2 != 0) throw Exception("不成对")
        if (indexList.isEmpty()) return Interval(0, size - 1)
        if (indexList[0] != 0) return Interval(0, indexList[0])
        for (i in 1 until indexList.size - 1 step 2) {
            if (indexList[i] != indexList[i + 1]) return Interval(indexList[i], indexList[i + 1])
        }
        if (indexList[indexList.size - 1] != size - 1) return Interval(indexList[indexList.size - 1], size - 1)
        return null
    }

    private fun initPairList(pairList: ArrayList<Pair>, indexList: ArrayList<Int>, height: IntArray, left: Int, right: Int) {
        val max = Data(-1, -1)
        val secondaryMax = Data(-1, -1)
        if (left >= right) throw Exception("非区间")
        maxList.clear()
        secondaryMaxList.clear()
        for (index in left..right) {
            val it = height[index]
            if (it >= max.v) {
                val lastMax = Data(max.index, max.v)
                max.index = index
                max.v = it
                maxList.add(Data(index, it))

                if (lastMax.v >= secondaryMax.v) {
                    secondaryMax.index = lastMax.index
                    secondaryMax.v = lastMax.v
                    secondaryMaxList.add(Data(secondaryMax.index, secondaryMax.v))

                }
            } else if (secondaryMax.v <= it) {
                secondaryMax.index = index
                secondaryMax.v = it
                secondaryMaxList.add(Data(index, it))

            }
        }
        maxList.filter { it.v >= max.v }.let {
            maxList.clear()
            maxList.addAll(it)
        }
        secondaryMaxList.filter { it.v >= secondaryMax.v }.let {
            secondaryMaxList.clear()
            secondaryMaxList.addAll(it)
        }
        // 从两组数据中求出距离最远的那一对
        var maxLeft = -1
        var maxLeftIndex = -1
        var maxRight = -1
        var maxRightIndex = -1
        var secondaryMaxLeft = -1
        var secondaryMaxLeftIndex = -1
        var secondaryMaxRight = -1
        var secondaryMaxRightIndex = -1
        for (i in 0 until maxList.size) {
            if (maxLeft == -1 || maxList[i].index < maxLeft) {
                maxLeft = maxList[i].index
                maxLeftIndex = i
            }
            if (maxRight == -1 || maxList[i].index > maxRight) {
                maxRight = maxList[i].index
                maxRightIndex = i
            }
        }
        for (i in 0 until secondaryMaxList.size) {
            if (secondaryMaxLeft == -1 || secondaryMaxList[i].index < secondaryMaxLeft) {
                secondaryMaxLeft = secondaryMaxList[i].index
                secondaryMaxLeftIndex = i
            }
            if (secondaryMaxRight == -1 || secondaryMaxList[i].index > secondaryMaxRight) {
                secondaryMaxRight = secondaryMaxList[i].index
                secondaryMaxRightIndex = i
            }
        }
        val v1 = Math.abs(maxLeft - secondaryMaxRight)
        val v2 = Math.abs(maxRight - secondaryMaxLeft)
        if (v1 > v2) {
            secondaryMax.index = secondaryMaxList[secondaryMaxRightIndex].index
            secondaryMax.v = secondaryMaxList[secondaryMaxRightIndex].v
            max.index = maxList[maxLeftIndex].index
            max.v = maxList[maxLeftIndex].v
        } else {

            secondaryMax.index = secondaryMaxList[secondaryMaxLeftIndex].index
            secondaryMax.v = secondaryMaxList[secondaryMaxLeftIndex].v
            max.index = maxList[maxRightIndex].index
            max.v = maxList[maxRightIndex].v
        }
        if (secondaryMax.index == -1 || secondaryMax.v == -1 || max.index == -1 || max.v == -1) throw Exception("边界问题")
        var added = false
        for (i in 0 until indexList.size step 2) {
            if (secondaryMax.index < indexList[i] && max.index > indexList[i]) {
                throw Exception("Error occur")
            }
            if (secondaryMax.index <= indexList[i]) {
                if (max.index < secondaryMax.index) {
                    indexList.add(i, secondaryMax.index)
                    indexList.add(i, max.index)
                } else {
                    indexList.add(i, max.index)
                    indexList.add(i, secondaryMax.index)
                }
                added = true
                break

            }

        }
        if (!added) {
            if (max.index < secondaryMax.index) {
                indexList.add(max.index)
                indexList.add(secondaryMax.index)
            } else {
                indexList.add(secondaryMax.index)
                indexList.add(max.index)
            }

        }
        if (secondaryMax.index < max.index) {
            pairList.add(Pair(secondaryMax, max))
        } else {
            pairList.add(Pair(max, secondaryMax))
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(_42().trap(intArrayOf(3)))
        }
    }
}