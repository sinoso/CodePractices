package leetcode.medium

import leetcode.testclass.ListNode
import printResult

fun main() {
    printResult(
        mergeInBetween(
            ListNode.createByInts(0, 1, 2, 3, 4, 5),
            a = 3,
            b = 4,
            ListNode.createByInts(1000000, 1000001, 1000002)
        ), ListNode.createByInts(0, 1, 2, 1000000, 1000001, 1000002, 5)
    )
}

private fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
    var currentNode = list1!!
    repeat(a - 1) {
        currentNode = currentNode.next!!
    }
    val bypassIn = currentNode
    repeat(b - a + 2) {
        currentNode = currentNode.next!!
    }
    val bypassOut = currentNode
    currentNode = list2!!
    while (currentNode.next != null)
        currentNode = currentNode.next!!
    bypassIn.next = list2
    currentNode.next = bypassOut
    return list1
}
