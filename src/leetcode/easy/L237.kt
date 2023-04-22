package leetcode.easy

import leetcode.testclass.ListNode


fun main() {
    var node = ListNode(4).apply { next = ListNode(5).apply { next = ListNode(1).apply { next = ListNode(9) } } }
    deleteNode(node.next)
    node.printAllN()
}

private fun deleteNode(node: ListNode?) {
    node!!.`val` = node.next!!.`val`
    node.next = node.next!!.next
}

private fun deleteNode2(node: ListNode?) {
    with(node!!) {
        `val` = next!!.`val`
        next = next!!.next
    }
}
