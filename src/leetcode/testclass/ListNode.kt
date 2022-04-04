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
    fun joinAll():String {
        var next: ListNode? = this
        val stringBuilder = StringBuilder()
        while (next != null) {
            stringBuilder.append("${next.`val`} ")
            next = next.next
        }
        return stringBuilder.toString()
    }

    companion object {
        fun createByArray(array: IntArray?): ListNode? {
            array?: return null
            if (array.isEmpty()) return null
            val head = ListNode(array[0])
            var current = head
            (1..array.lastIndex).forEach { idx ->
                current.next = ListNode(array[idx]).also { current = it }
            }
            return head
        }
        fun createByInts(vararg values: Int): ListNode {
            val head = ListNode(values.first())
            var current = head
            (1..values.lastIndex).forEach { idx ->
                current.next = ListNode(values[idx]).also { current = it }
            }
            return head
        }
    }
}
