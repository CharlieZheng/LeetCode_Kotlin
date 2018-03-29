package Breadth_first_Search

import base.TreeNode

class _102 {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        if (root == null) return result
        val stack = ArrayList<TreeNode?>()
        val stackNext = ArrayList<TreeNode?>()
        stack.add(root)
        while (!stack.isEmpty()) {
            val row = ArrayList<Int>()
            while (!stack.isEmpty()) {
                val item = stack.removeAt(0)
                item?.`val`?.let { row.add(it) }
                item?.left?.let { stackNext.add(it) }
                item?.right?.let { stackNext.add(it) }
            }
            result.add(row)
            stack.addAll(stackNext)
            stackNext.clear()
        }
        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val root = TreeNode(1)
            root.left = TreeNode(8)
            root.right = TreeNode(2)
            root.left?.left = TreeNode(5)

            root.right?.right = TreeNode(3)


            val result = _102().levelOrder(root)
            result.forEach {
                it.forEach { print(it.toString() + "\t") }
                print("\n")
            }

        }
    }
}