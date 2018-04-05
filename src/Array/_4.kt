package Array

import java.util.*

class _4 {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val all = ArrayList<Int>()
        nums1.forEach { all.add(it) }
        nums2.forEach { all.add(it) }
        Collections.sort(all)
        val size = all.size
        if (size % 2 == 0)
            return (all[size / 2 - 1] + all[size / 2]) / 2.0
        else return all[size / 2].toDouble()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(_4().findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))

        }
    }
}