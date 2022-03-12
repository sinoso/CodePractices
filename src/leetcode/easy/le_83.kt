package leetcode.easy

import leetcode.testclass.ListNode

fun main() {
    val node = ListNode.createByInts(1, 1, 2).also { it.printAllN() }
    deleteDuplicates(node)?.printAllN() ?: println()
    val node2 = ListNode.createByInts(1, 2,3,3,4,4,4,5).also { it.printAllN() }
    deleteDuplicates(node2)?.printAllN() ?: println()
}

private fun deleteDuplicates(head: ListNode?): ListNode? {
    head ?: return head
    var currentNode = head
    var lastNode = head
    while (currentNode!!.next != null) {
        if (currentNode.next!!.`val` != lastNode!!.`val`) {
            lastNode.next = currentNode.next
            lastNode = currentNode.next!!
        }
        currentNode = currentNode.next
    }
    lastNode!!.next = null
    return head
}
