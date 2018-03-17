package Two_Pointers

import base.ListNode

class _19 {
    private fun revert(head: ListNode?): ListNode? {
        if (head == null) return null
        if (head.next == null) return head

        var headTemp = head
        var temp1: ListNode? = ListNode(0)
        var temp2: ListNode? = ListNode(0)
        temp2?.next = headTemp.next
        var index = 0
        while (temp2?.next != null) {
            temp1?.next = temp2.next
            temp2.next = temp1?.next?.next
            temp1?.next?.next = headTemp
            if (index++ <= 0)
                headTemp?.next = null
            headTemp = temp1?.next
        }
        temp1 = null
        temp2 = null
        return headTemp
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var revert = revert(head)
        var index = 1
        var revertTemp = revert
        var temp: ListNode? = ListNode(-1)
        while (true) {
            if (revertTemp == null) break
            if (n == 1) {
                revert = revert?.next
                return revert(revert)
            }
            if (index == n - 1) {
                temp?.next = revertTemp.next
                revertTemp.next = revertTemp.next?.next
                temp?.next?.next = null
                break
            }
            index++
            revertTemp = revertTemp.next
        }
        temp = null

        return revert(revert)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val listNode1 = ListNode(0)
            val listNode2 = ListNode(1)
            val listNode3 = ListNode(2)
            val listNode4 = ListNode(3)
            val listNode5 = ListNode(4)
            val listNode6 = ListNode(5)
            val listNode7 = ListNode(6)
            val listNode8 = ListNode(7)
//            listNode1.next = listNode2
            listNode2.next = listNode3
            listNode3.next = listNode4
            listNode4.next = listNode5
            listNode5.next = listNode6
            listNode6.next = listNode7
            listNode7.next = listNode8
            listNode1.print()
            val result = _19().removeNthFromEnd(listNode1, 1)
            result?.print()
        }
    }
}