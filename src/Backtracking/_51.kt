package Backtracking

/**
 * 这道题直接用 22 题的解题思路来做
 * 见 https://github.com/CharlieZheng/LeetCode
 */
class _51 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _51()
            val result = obj.solveNQueens(6)
            result.forEachIndexed { i, it ->
                if (i == 0) print("[")
                it.forEachIndexed { index, s ->
                    if (index == 0) print("[")
                    if (index == it.size - 1) println("\"$s\"]")
                    else println("\"$s\",")
                }
                if (i == result.size - 1) print("]")
                else println(",")
            }
        }
    }

    data class Item(val item: ArrayList<String>, val indexSet: ArrayList<Int>)

    fun solveNQueens(n: Int): List<List<String>> {
        val result = ArrayList<List<String>>()
        val set = ArrayList<String>()
        var item: String
        for (i in 0 until n) {
            item = ""
            for (j in 0 until n) {
                if (i == j)
                    item += "Q"
                else item += "."
            }
            set.add("$item")
        }
        for (i in 0 until n)
            solveNQueens2(i, set, Item(ArrayList<String>(), ArrayList<Int>()), result, n)
        if (n == 0) result.add(ArrayList<String>())
        return result
    }

    private fun solveNQueens2(i: Int, set: ArrayList<String>, item: Item, result: ArrayList<List<String>>, n: Int) {
        if ((item.indexSet.isNotEmpty() && Math.abs(item.indexSet[item.indexSet.size - 1] - i) <= 1) || same(item, i, n)) return
        item.item.add(set[i])
        item.indexSet.add(i)
        if (item.indexSet.size == n) {
            result.add(item.item)
            return
        }
        Array<Int>(n, { it -> it }).filter { !item.indexSet.contains(it) }.forEach {
            val p1 = ArrayList<String>()
            p1.addAll(item.item)
            val p2 = ArrayList<Int>()
            p2.addAll(item.indexSet)
            val newItem = Item(p1, p2)

            solveNQueens2(it, set, newItem, result, n)
        }
    }

    private fun same(item: Item, index: Int, n: Int): Boolean {
        val set1 = HashSet<Int>() // 斜线 1
        val set2 = HashSet<Int>() // 斜线 2
        for (i in 0 until item.indexSet.size) {
            val temp1 = item.indexSet[i]
            if (set1.contains(temp1 - i) || set2.contains(n - 1 - temp1 - i))
                return true
            set1.add(temp1 - i)
            set2.add(n - 1 - temp1 - i)
        }
        if (set1.contains(index - item.indexSet.size) || set2.contains(n - 1 - index - item.indexSet.size))
            return true
        return false
    }

}