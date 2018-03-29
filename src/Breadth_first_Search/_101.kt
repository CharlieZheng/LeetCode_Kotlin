package Breadth_first_Search

import base.TreeNode
import java.util.*

class _101 {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        val stack = Stack<TreeNode?>()
        val stackNext = Stack<TreeNode?>()
        stack.push(root)
        var length = 0
        var isContinue = true
        while (isContinue) {
            while (!stack.isEmpty()) {
                val treeNode = stack.pop()
                stackNext.add(treeNode?.left)
                stackNext.add(treeNode?.right)
            }
            length = stackNext.size
            isContinue = false
            for (i in 0 until length) {
                if (stackNext[i]?.left != null || stackNext[i]?.right != null) isContinue = true
                if (stackNext[i]?.`val` != stackNext[length - 1 - i]?.`val`) {
                    return false
                }
            }
            stack.addAll(stackNext)
            stackNext.clear()
        }
        return true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val root = TreeNode(1)
            root.left = TreeNode(2)
            root.right = TreeNode(2)
            root.left?.left = TreeNode(3)

            root.right?.right = TreeNode(3)


            root?.left?.left?.left = TreeNode(4)
            root.right?.right?.right = TreeNode(4)
            print(_101().isSymmetric(root))
        }
    }
}