package leetcode.medium

import leetcode.testclass.ListNode

fun main() {
    oddEvenList(ListNode(1).apply {
        next = ListNode(2).apply { next = ListNode(3).apply { next = ListNode(4).apply { next = ListNode(5) } } }
    })?.printAllN()
    oddEvenList(ListNode(1).apply {
        next = ListNode(2).apply { next = ListNode(3).apply { next = ListNode(4) } }
    })?.printAllN()
    oddEvenList(ListNode(1).apply {
        next = ListNode(2)
    })?.printAllN()
    oddEvenList(ListNode(1))?.printAllN()
    oddEvenList(null)?.printAllN()
}

private fun oddEvenList(head: ListNode?): ListNode? {
    var oddEnd = head ?: return head
    val evenHead = head.next ?: return head
    var evenEnd = evenHead
    var oddFlag = true
    var currentNode = head.next?.next
    while (currentNode != null) {
        if (oddFlag) {
            oddEnd.next = currentNode
            oddEnd = currentNode
        } else {
            evenEnd.next = currentNode
            evenEnd = currentNode
        }
        oddFlag = !oddFlag
        currentNode = currentNode.next
    }
    oddEnd.next = evenHead
    evenEnd.next = null
    return head
}

// 일단 총 4개의 노드를 특정한다.
// odd 시작 even시작 odd 끝 even 끝.
//odd 시작은 head
//even시작은 head.next

