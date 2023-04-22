package leetcode.medium

import leetcode.testclass.ListNode

fun main() {
    partition(head = ListNode.createByInts(1, 4, 3, 2, 5, 2), x = 3)
}

private fun partition(head: ListNode?, x: Int): ListNode? {
    var sHead: ListNode? = null
    var sTail: ListNode? = null
    var lHead: ListNode? = null
    var lTail: ListNode? = null
    var currentNode = head
    while (currentNode != null) {
        if (x <= currentNode.`val`) {
            if (lHead == null) {
                lHead = currentNode
                lTail = lHead
            } else {
                lTail!!.next = currentNode
                lTail = lTail.next
            }
        } else {
            if (sHead == null) {
                sHead = currentNode
                sTail = sHead
            } else {
                sTail!!.next = currentNode
                sTail = sTail.next
            }
        }
        currentNode = currentNode.next
    }
    if (sHead != null) {
        sTail!!.next = lHead
    }
    if (lHead != null)
        lTail!!.next = null
    if (sHead ==null)
        return lHead
    return sHead
}
