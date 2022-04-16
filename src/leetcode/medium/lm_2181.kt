package leetcode.medium

import leetcode.testclass.ListNode
import printResult
import java.util.Arrays

fun main() {
    printResult(
        mergeNodes(ListNode.createByInts(0, 3, 1, 0, 4, 5, 2, 0))!!.joinAll(),
        ListNode.createByInts(4, 11).joinAll()
    )
}

fun mergeNodes(head: ListNode?): ListNode? {
    var current = head!!.next
    var lastNoneZero = current
    current = current!!.next
    while (current != null) {
        if (current.`val` == 0) {
            lastNoneZero!!.next = current.next
            lastNoneZero = lastNoneZero.next
            current = lastNoneZero
        } else
            lastNoneZero!!.`val` += current.`val`
        current = current?.next
    }
    return head.next
}

fun mergeNodes2(head: ListNode?): ListNode? {
    var current = head!!.next
    val newHead = head.next
    var lastNoneZero = newHead
    var firstNode: ListNode? = null
    while (current != null) {
        if (current.`val` == 0) {
            if (firstNode != null)
                firstNode.next = current
            lastNoneZero!!.next = firstNode
            lastNoneZero = lastNoneZero.next
            lastNoneZero!!.next = null
            firstNode = null
        } else if (firstNode == null)
            firstNode = current
        else
            firstNode.`val` += current.`val`
        current = current.next
    }
    return newHead
}
