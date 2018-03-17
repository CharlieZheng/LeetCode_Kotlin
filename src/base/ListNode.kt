package base

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
    fun print() {
        var nextTemp: ListNode? = this
        while (nextTemp != null) {
            System.out.print(nextTemp.`val`.toString() + "\t")
            nextTemp = nextTemp.next
        }
        System.out.println()
    }
}