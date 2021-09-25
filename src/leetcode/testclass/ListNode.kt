package leetcode.testclass

class ListNode(val `val`:Int) {
    var next: ListNode? = null

    fun printAllN() {
        var next: ListNode? = this
        while (next != null) {
            print("${next.`val`} ")
            next = next.next
        }
        println()
    }
}