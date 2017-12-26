package Binary_Search_Tree

import base.TreeNode
import java.util.*

class _530 {
    companion object {
        fun getMinimumDifference(root: TreeNode?): Int {
            if (root == null) return 0
            var result = Integer.MAX_VALUE
            val queue = LinkedList<TreeNode>()
            queue.add(root)
            var left: Int
            var right: Int
            while (!queue.isEmpty()) {
                left = 0
                right = 0
                val item = queue.poll()
                if (item.left != null) {
                    left = item.left!!.`val`
                    queue.add(item.left!!)
                }
                if (item.right != null) {
                    right = item.right!!.`val`
                    queue.add(item.right!!)
                }
                if (Math.abs(item.`val` - left) <= Math.abs(item.`val` - right) && Math.abs(item.`val` - left) < result) {
                    result = Math.abs(item.`val` - left)
                }
                if (Math.abs(item.`val` - left) >= Math.abs(item.`val` - right) && Math.abs(item.`val` - right) < result) {
                    result = Math.abs(item.`val` - right)
                }
            }
            return result
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