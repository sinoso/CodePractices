package leetcode.easy

import leetcode.testclass.ListNode

fun main() {

}

private fun deleteNodes(head: ListNode?, m: Int, n: Int): ListNode? {
    var current = head
    while (current != null) {
        repeat(m - 1) {
            current = current?.next
        }
        val lastTail = current
        repeat(n + 1) {
            current = current?.next
        }
        lastTail?.next = current
    }
    return head
}