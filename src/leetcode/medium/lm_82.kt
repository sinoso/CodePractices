package leetcode.medium

import leetcode.testclass.ListNode

fun main() {
    val head = ListNode.createByInts(1, 1, 2, 3)
    head.printAllN()
    deleteDuplicates(head)?.printAllN() ?: println(" 없음 ")
    println()
    val head2 = ListNode.createByInts(1, 2, 2, 3, 3, 4)
    head2.printAllN()
    deleteDuplicates(head2)?.printAllN() ?: println(" 없음 ")
    val head3 = ListNode.createByInts(1, 2, 2, 3, 3)
    println()
    head3.printAllN()
    deleteDuplicates(head3)?.printAllN() ?: println(" 없음 ")
    println()
    ListNode.createByInts(1, 2, 3).also {
        it.printAllN()
        deleteDuplicates(it)?.printAllN() ?: println(" 없음 ")
    }
}

// 14:00
// 3종류의 가능성
// 처음이 중복
// 중간이 중복
// 마지막이 중복
private fun deleteDuplicates(head: ListNode?): ListNode? {
    val preHead = ListNode(-101).apply { next = head }
    var preNode: ListNode = preHead
    var lastNode: ListNode = preHead.next ?: return null
    var currentNode = lastNode.next
    var notDuplicated = true
    while (currentNode != null) {
        if (lastNode.`val` != currentNode.`val`) {
            if (notDuplicated) {
                preNode.next = lastNode
                preNode = lastNode
                lastNode = currentNode
                currentNode = currentNode.next
                continue
            }
            lastNode = currentNode
            currentNode = currentNode.next
            notDuplicated = true
            continue
        }
        notDuplicated = false
        currentNode = currentNode.next
    }
    if (notDuplicated)
        preNode.next = lastNode
    else
        preNode.next = null

    return preHead.next
}

private fun deleteDuplicates2(head: ListNode?): ListNode? {
    head?.let { head.next } ?: return head
    var newHead = head
    var notDuplicated = true
    while (newHead != null) {
        if (newHead.next == null)
            return if (notDuplicated) head else null
        if (newHead.`val` != newHead.next!!.`val`) {
            if (notDuplicated)
                break
            if (newHead.next!!.next == null)
                return newHead.next
            if (newHead.next!!.`val` != newHead.next!!.next!!.`val`) {
                newHead = newHead.next
                break
            }
            newHead = newHead.next
            notDuplicated = true
            continue
        }
        newHead = newHead.next
        notDuplicated = false
    }
    newHead ?: return newHead

    var preNode: ListNode = newHead
    var lastNode: ListNode = newHead.next!!
    var currentNode = lastNode.next
    notDuplicated = true
    while (currentNode != null) {
        if (lastNode.`val` != currentNode.`val`) {
            if (notDuplicated) {
                preNode.next = lastNode
                preNode = lastNode
                lastNode = currentNode
                currentNode = currentNode.next
                continue
            }
            lastNode = currentNode
            currentNode = currentNode.next
            notDuplicated = true
            continue
        }
        notDuplicated = false
        currentNode = currentNode.next
    }
    if (notDuplicated)
        preNode.next = lastNode
    else
        preNode.next = null

    return newHead
}
