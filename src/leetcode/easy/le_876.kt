package leetcode.easy

import leetcode.testclass.ListNode

fun main() {
    println(middleNode(ListNode(1).also { it1 -> it1.next = ListNode(2).also { it2 -> it2.next = ListNode(3).also { it3 -> it3.next = ListNode(4) } } })?.i)
    println(middleNode(ListNode(1).also { it1 -> it1.next = ListNode(2).also { it2 -> it2.next = ListNode(3).also { it3 -> it3.next = ListNode(4).also { it4 -> it4.next = ListNode(5) } } } })?.i)
    println(middleNode(ListNode(1).also { it1 -> it1.next = ListNode(2).also { it2 -> it2.next = ListNode(3).also { it3 -> it3.next = ListNode(4).also { it4 -> it4.next = ListNode(5) } } } })?.i)
    println(middleNode(ListNode(1))?.i)
}



private fun middleNode(head: ListNode?): ListNode? {
    var left = head
    var right = head
    while (right != null) {
        right = right.next?.also { left = left?.next }
        right = right?.next
    }
    return left
}