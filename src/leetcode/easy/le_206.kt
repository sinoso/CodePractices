package leetcode.easy

import leetcode.testclass.ListNode

fun main() {
    var list1 = ListNode(1).also { it1 -> it1.next = ListNode(2).also { it2 -> it2.next = ListNode(3).also { it3 -> it3.next = ListNode(4) } } }
    var list2 = ListNode(1).also { it1 -> it1.next = ListNode(2).also { it2 -> it2.next = ListNode(3) } }
    var list3 = ListNode(1).also { it1 -> it1.next = ListNode(2) }
    var list4 = ListNode(1)
    var list5: ListNode? = null
    reverseList(list1)?.printAllN()
    reverseList(list2)?.printAllN()
    reverseList(list3)?.printAllN()
    reverseList(list4)?.printAllN()
    reverseList(list5)?.printAllN()
}

private fun reverseList(head: ListNode?): ListNode? {
    var left:ListNode? = null
    var right = head
    while (right != null) {
        var temp = left
        left = right
        right = right.next
        left.next = temp
    }
    return left
}
//
//private fun rec(node: ListNode?): ListNode? {
//    if (node?.next != null) {
//        var temp = rec(node.next)
//        return temp?.apply { next = node }
//    }
//    return node
//}
//private fun rec(node: ListNode?): ListNode? {
//    if (node?.next != null)
//        return rec(node.next)?.apply { next = node }
//    return node
//}