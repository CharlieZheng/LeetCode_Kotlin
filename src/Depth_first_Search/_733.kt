package Depth_first_Search

import java.util.*
import kotlin.collections.HashSet

class _733 {
    class Point(val x: Int, val y: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Point

            if (x != other.x) return false
            if (y != other.y) return false

            return true
        }

        override fun hashCode(): Int {
            var result = x
            result = 31 * result + y
            return result
        }
    }

    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        /*  1 1 1
            1 1 0
            1 0 1
            */
        val value = image[sr][sc]
        val stack = Stack<Point>()
        val set = HashSet<Point>()
        stack.push(Point(sr, sc))
        set.add(Point(sr, sc))
        while (!stack.isEmpty()) {
            val point = stack.pop()
            point.let {
                image[it.x][it.y] = newColor
                if (!set.contains(Point(it.x - 1, it.y)) && it.x - 1 >= 0 && image[it.x - 1][it.y] == value) {
                    stack.push(Point(it.x - 1, it.y))
                    set.add(Point(it.x - 1, it.y))
                }
                if (!set.contains(Point(it.x + 1, it.y)) && it.x + 1 < image.size && image[it.x + 1][it.y] == value) {
                    stack.push(Point(it.x + 1, it.y))
                    set.add(Point(it.x + 1, it.y))
                }
                if (!set.contains(Point(it.x, it.y - 1)) && it.y - 1 >= 0 && image[it.x][it.y - 1] == value) {
                    stack.push(Point(it.x, it.y - 1))
                    set.add(Point(it.x, it.y - 1))
                }
                if (!set.contains(Point(it.x, it.y + 1)) && it.y + 1 < image[it.x].size && image[it.x][it.y + 1] == value) {
                    stack.push(Point(it.x, it.y + 1))
                    set.add(Point(it.x, it.y + 1))
                }
            }
        }
        return image
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val _1 = intArrayOf(1, 1, 1)
            val _2 = intArrayOf(1, 1, 0)
            val _3 = intArrayOf(1, 0, 1)
            val o = _733().floodFill(arrayOf<IntArray>(_1, _2, _3), 1, 1, 2)
            for (i in 0 until o.size) {
                for (j in 0 until o[i].size) {
                    print(o[i][j].toString() + "\t")
                }
                println()
            }
        }
    }
}