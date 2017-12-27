package Breadth_first_Search

import java.util.*

class _200 {
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

    fun requireCalculate(list: ArrayList<HashSet<Point>>, grid: Array<CharArray>, point: Point): Boolean {
        list.forEach {
            if (it.contains(point)) return false
        }
        return grid[point.x][point.y] == '1'
    }

    fun numIslands(grid: Array<CharArray>): Int {
        val islandSetList = ArrayList<HashSet<Point>>()
        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                val islandSet = HashSet<Point>()
                if (!requireCalculate(islandSetList, grid, Point(i, j))) continue
                val stack = Stack<Point>()
                stack.push(Point(i, j))
                islandSet.add(Point(i, j))
                while (!stack.isEmpty()) {
                    val p = stack.pop()
                    if (p.x - 1 >= 0 && grid[p.x - 1][p.y] == '1' && !islandSet.contains(Point(p.x - 1, p.y))) {
                        val temp = Point(p.x - 1, p.y)
                        stack.push(temp)
                        islandSet.add(temp)
                    }
                    if (p.x + 1 < grid.size && grid[p.x + 1][p.y] == '1' && !islandSet.contains(Point(p.x + 1, p.y))) {
                        val temp = Point(p.x + 1, p.y)
                        stack.push(temp)
                        islandSet.add(temp)
                    }
                    if (p.y - 1 >= 0 && grid[p.x][p.y - 1] == '1' && !islandSet.contains(Point(p.x, p.y - 1))) {
                        val temp = Point(p.x, p.y - 1)
                        stack.push(temp)
                        islandSet.add(temp)
                    }
                    if (p.y + 1 < grid[p.x].size && grid[p.x][p.y + 1] == '1' && !islandSet.contains(Point(p.x, p.y + 1))) {
                        val temp = Point(p.x, p.y + 1)
                        stack.push(temp)
                        islandSet.add(temp)
                    }
                }

                islandSetList.add(islandSet)
            }
        }
        return islandSetList.size
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            /*val _1 = charArrayOf('1', '1', '0', '0', '0')
            val _2 = charArrayOf('1', '1', '0', '0', '0')
            val _3 = charArrayOf('0', '0', '1', '0', '0')
            val _4 = charArrayOf('0', '0', '0', '1', '1')*/
            val _1 = charArrayOf('1', '1', '1', '1', '0')
            val _2 = charArrayOf('1', '1', '0', '1', '0')
            val _3 = charArrayOf('1', '1', '0', '0', '0')
            val _4 = charArrayOf('0', '0', '0', '0', '0')
            val array = arrayOf<CharArray>(_1, _2, _3, _4)
            print(_200().numIslands(array))
        }
    }
}