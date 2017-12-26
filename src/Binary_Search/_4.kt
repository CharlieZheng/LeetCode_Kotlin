package Binary_Search

import java.util.*

class _4 {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val both = ArrayList<Int>()
        nums1.forEach {
            both.add(it)
        }
        nums2.forEach {
            both.add(it)
        }
        Collections.sort(both)
        if (both.size == 0) return 0.0
        if (both.size == 1) {
            return both.get(0) / 2.0
        }
        if (both.size % 2 == 0) {
            return (both.get(both.size / 2 - 1) + both.get(both.size / 2)) / 2.0
        } else {
            return both.get(both.size / 2).toDouble()
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = _4()
            val nums1 = intArrayOf(1, 3)
            val nums2 = intArrayOf(2, 3, 5, 6, 34, 5, 2, 4, 6, 7, 34, 2, 1, 90)
            print(o.findMedianSortedArrays(nums1, nums2))
        }
    }
}