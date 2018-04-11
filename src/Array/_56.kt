package Array

import base.Interval
import java.util.*

class _56 {
    fun merge(intervals: List<Interval>): List<Interval> {
        val size = intervals.size
        val indexList = ArrayList<Int>()
        for (i in size - 1 downTo 0) {
            val big = intervals[i]
            for (j in 0 until i) {
                val item = intervals[j]
                if (item.start <= big.end && item.end >= big.start) {
                    if (item.start > big.start) {
                        intervals[j].start = big.start
                    }
                    if (item.end < big.end) {
                        intervals[j].end = big.end
                    }
                    indexList.add(i)
                    break
                }
            }
        }
        Collections.sort(indexList)
        var removeCnt = 0
        indexList.forEach {
            (intervals as ArrayList).removeAt(it - removeCnt)
            removeCnt++
        }
        return intervals
//        return    intervals.subList(0, size -remove)

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val list = ArrayList<Interval>()
//            list.add(Interval(1, 3))
//            list.add(Interval(2, 6))
//            list.add(Interval(8, 10))
//            list.add(Interval(15, 18))
            _56().merge(list).forEach {
                println("[" + it.start + ", " + it.end + "]")
            }

        }
    }
}