package Depth_first_Search

import java.util.*
import kotlin.collections.HashSet

class _695 {
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

    fun getNum(grid: Array<IntArray>, point: Point): Int {
        val stack = Stack<Point>()
        val set = HashSet<Point>()
        stack.push(point)
        set.add(point)
        var num = 0
        while (!stack.isEmpty()) {
            val temp = stack.pop()
            if (grid[temp.x][temp.y] == 1) {
                num++
                if (!set.contains(Point(temp.x - 1, temp.y)) && temp.x - 1 >= 0) {
                    stack.push(Point(temp.x - 1, temp.y))
                    set.add(Point(temp.x - 1, temp.y))
                }
                if (!set.contains(Point(temp.x + 1, temp.y)) && temp.x + 1 < grid.size) {
                    stack.push(Point(temp.x + 1, temp.y))
                    set.add(Point(temp.x + 1, temp.y))
                }
                if (!set.contains(Point(temp.x, temp.y - 1)) && temp.y - 1 >= 0) {
                    stack.push(Point(temp.x, temp.y - 1))
                    set.add(Point(temp.x, temp.y - 1))
                }
                if (!set.contains(Point(temp.x, temp.y + 1)) && temp.y + 1 < grid[temp.x].size) {
                    stack.push(Point(temp.x, temp.y + 1))
                    set.add(Point(temp.x, temp.y + 1))
                }
            }
        }
        return num
    }

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var max = Int.MIN_VALUE
        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                if (max < getNum(grid, Point(i, j)))
                    max = getNum(grid, Point(i, j))
            }
        }
        return max
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = _695()
            val _1 = intArrayOf(1, 0, 1)
            val _2 = intArrayOf(0, 1, 1)
            print(o.maxAreaOfIsland(arrayOf<IntArray>(_1, _2)))
        }
    }
}