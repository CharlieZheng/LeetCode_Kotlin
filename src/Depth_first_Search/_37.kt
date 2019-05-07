package Depth_first_Search

import java.util.*
import kotlin.collections.HashSet

class _37 {

    private val result = ArrayList<Array<CharArray>>()

    companion object {
        const val N = 9
        @JvmStatic
        fun main(args: Array<String>) {
            val lambda1 = { it: Int -> arrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.')[it] }
            val lambda2 = { it: Int -> arrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.')[it] }
            val lambda3 = { it: Int -> arrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.')[it] }
            val lambda4 = { it: Int -> arrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3')[it] }
            val lambda5 = { it: Int -> arrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1')[it] }
            val lambda6 = { it: Int -> arrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6')[it] }
            val lambda7 = { it: Int -> arrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.')[it] }
            val lambda8 = { it: Int -> arrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5')[it] }
            val lambda9 = { it: Int -> arrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')[it] }
            val board = arrayOf(CharArray(9, lambda1), CharArray(9, lambda2),
                    CharArray(9, lambda3), CharArray(9, lambda4),
                    CharArray(9, lambda5), CharArray(9, lambda6),
                    CharArray(9, lambda7), CharArray(9, lambda8),
                    CharArray(9, lambda9))
            val obj = _37()
            obj.solveSudoku(board)
        }
    }

    fun solveSudoku(board: Array<CharArray>): Unit {
        dfs(board, 0, 0)
        result.forEach {
            it.forEach {
                it.forEach {
                    print("$it\t")
                }
                println()
            }
        }
    }

    private fun dfs(board: Array<CharArray>, x: Int, y: Int) {
        val all = HashSet<Char>()
        for (i in 1..N) all.add((i + 48).toChar())
        for (i in 0 until N) {
            var item = board[i][y]
            if (item != '.' && all.contains(item)) all.remove(item)
            item = board[x][i]
            if (item != '.' && all.contains(item)) all.remove(item)

        }
        if (all.isNotEmpty())
            for (i in all) {
                board[x][y] = i
                val lambda = { _: Int -> CharArray(9) }
                val newBoard = Array<CharArray>(9, lambda)
                board.forEachIndexed { i, chars ->
                    chars.forEachIndexed { j, c ->
                        newBoard[i][j] = c
                    }
                }
                if (x < N - 1)
                    dfs(newBoard, x + 1, y)
                else if (y < N - 1) dfs(newBoard, 0, y + 1)
                else result.add(board)
            }
        else
            if (x == N - 1 && y == N - 1) {
                result.add(board)
            }
    }
}