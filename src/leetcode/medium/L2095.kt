package leetcode.medium

import leetcode.testclass.ListNode


fun main() {
//    deleteMiddle(ListNode.createByInts(1, 3, 4, 7, 1, 2, 6))?.printAllN()
    deleteMiddle(ListNode.createByInts(1, 2))?.printAllN()
    deleteMiddle(ListNode.createByInts(1))?.printAllN()
}

// 14:02 ~ 14:13
private fun deleteMiddle(head: ListNode?): ListNode? {
    head?.next ?: return null

    var beforeMid = head
    var current = head.next?.next

    while (current?.next != null) {
        beforeMid = beforeMid?.next
        current = current.next?.next
    }

    beforeMid?.next = beforeMid?.next?.next
    return head
}
// 0..6
// 0 1 2 3 4 5 6
// Mid current
// 0   2
// 1   4
// 2   6
// 3   8 stop

// 0..3
// 0 1 2 3
// 0  2
// 1  3 stop
