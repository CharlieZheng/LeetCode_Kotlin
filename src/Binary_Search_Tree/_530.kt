package Binary_Search_Tree

import base.TreeNode
import java.util.*

class _530 {
    companion object {
        fun getMinimumDifference(root: TreeNode?): Int {
            if (root == null) return 0
            var result = Integer.MIN_VALUE
            val queue = LinkedList<TreeNode>()
            queue.add(root)
            var left: Int
            var right: Int
            var b =true
            while (!queue.isEmpty()) {
                left = 0
                right = 0
                val item = queue.poll()

                item.left ?.let {
                    left = it.`val`
                    queue.add(it)
                }
                item.right ?.let {
                    right = it.`val`
                    queue.add(it)
                }
                if (Math.abs(item.`val` - left) >= Math.abs(item.`val` - right) && Math.abs(item.`val` - left) > result) {
                    b = if (left-item.`val`<0) false else true
                    result = Math.abs(left-item.`val`)
                }
                if (Math.abs(item.`val` - left) <= Math.abs(item.`val` - right) && Math.abs(item.`val` - right) > result) {
                    b = if (right-item.`val`<0) false else true
                    result = Math.abs(right-item.`val`)
                }
            }
            return if (b) result else -result
        }

        @JvmStatic
        fun main(args: Array<String>) {
            val treeNode = TreeNode(1)
            treeNode.right = TreeNode(3)
            treeNode.right!!.left = TreeNode(2)
            println(getMinimumDifference(treeNode))
        }
    }

}