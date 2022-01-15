package leetcode.testclass

class ListNode(var `val`: Int) {

    var next: ListNode? = null

    fun printAllN() {
        var next: ListNode? = this
        while (next != null) {
            print("${next.`val`} ")
            next = next.next
        }
        println()
    }

    companion object {
        fun createByArray(array: IntArray): ListNode {
            val head = ListNode(array[0])
            var current = head
            (1..array.lastIndex).forEach { idx ->
                current.next = ListNode(array[idx]).also { current = it }
            }
            return head
        }
    }
}
