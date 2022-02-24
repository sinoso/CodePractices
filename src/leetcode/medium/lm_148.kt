package leetcode.medium

import leetcode.testclass.ListNode

fun main() {

}

private fun sortList(head: ListNode?): ListNode? {
    head ?: return head
    val nodeMap = HashMap<ListNode, Int>()
    var current = head
    while (current != null) {
        nodeMap[current] = current.`val`
        current = current.next
    }
    val returnHead: ListNode
    nodeMap.entries.sortedBy { it.value }.also { returnHead = it.first().key }
        .fold(null) { lastNode: ListNode?, entry ->
            lastNode?.let {
                it.next = entry.key
            }
            entry.key.next = null
            entry.key
        }
    return returnHead
}

