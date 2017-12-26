package tree

import base.TreeNode
import java.util.*
import kotlin.collections.ArrayList

class _572 {
    fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {
        val s1 = Stack<TreeNode>()
        val s2 = Stack<TreeNode>()
        var curItem1 = s
        var curItem2 = t
        val array1 = ArrayList<Int>()
        val array2 = ArrayList<Int>()
        while (!s1.isEmpty() || curItem1 != null) {
            if (curItem1 != null) {
                s1.push(curItem1)
                curItem1 = curItem1.left
            } else {
                val temp = s1.pop()
                array1.add(temp.`val`)
                curItem1 = temp?.right
            }
        }
        while (!s2.isEmpty() || curItem2 != null) {
            if (curItem2 != null) {
                s2.push(curItem2)
                curItem2 = curItem2.left
            } else {
                val temp = s2.pop()
                array2.add(temp.`val`)
                curItem2 = temp?.right
            }
        }
        println(array1)
        println(array2)
        val result = true
        for (index in array2.indices) {
            if (array1[index] != array2[index]) {
                return false
            }
        }
        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val o = _572()
            val treeNode = TreeNode(1)
            treeNode.right = TreeNode(2)
            treeNode.right?.left = TreeNode(4)
            val left = TreeNode(4)
            left.left = TreeNode(1)
            left.right = TreeNode(2)
            print(o.isSubtree(treeNode, left))
        }
    }
}