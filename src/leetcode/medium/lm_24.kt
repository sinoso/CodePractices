package leetcode.medium

import leetcode.testclass.ListNode

fun main() {
//    swapPairs(ListNode.createByArray(intArrayOf(1, 2, 3, 4)))?.printAllN()
//    swapPairs(ListNode.createByArray(intArrayOf(1, 2)))?.printAllN()
//    swapPairs(ListNode.createByArray(intArrayOf(1, 2, 3)))?.printAllN()
    swapPairs(ListNode.createByArray(intArrayOf(2, 5, 3, 4, 6, 2, 2)))?.printAllN()
//    swapPairs(ListNode.createByArray(intArrayOf(1)))?.printAllN()
}

private fun swapPairs(head: ListNode?): ListNode? {
    head ?: return head
    val currentHead = head.next ?: return head
    head.next = currentHead.next
    currentHead.next = head
    var currentNode = head
    var firstNode:ListNode?
    var secondNode:ListNode?
    while (currentNode != null) {
        firstNode = currentNode.next ?: return currentHead
        secondNode = firstNode.next ?: return currentHead
        firstNode.next = secondNode.next
        secondNode.next = firstNode
        currentNode.next = secondNode
        currentNode = firstNode
    }
    return currentHead
}
