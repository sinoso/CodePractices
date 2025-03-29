package leetcode.hard

import leetcode.testclass.ListNode
import kotlin.collections.HashMap

fun main() {
    mergeKLists(
        arrayOf(
            ListNode.createByInts(1, 4, 5),
            ListNode.createByInts(1, 3, 4),
            ListNode.createByInts(1, 3, 4),
        )
    )
}

private fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    class NodeContainer {
        var head: ListNode? = null
        var tail: ListNode? = null
        fun addNode(node: ListNode) {
            if (tail == null) {
                head = node
            } else {
                tail?.next = node
            }
            tail = node
        }
    }
    val table = HashMap<Int, NodeContainer>()
    for (head in lists) {
        var current = head
        while (current != null) {
            val container = table[current.`val`] ?: NodeContainer().also { table[current!!.`val`] = it }
            container.addNode(current)
            current = current.next
        }
    }
    val sortedList = table.entries.sortedByDescending { it.key }.map { it.value }
    return if (sortedList.isEmpty())
        null
    else sortedList.reduce { nodeContainer, acc ->
        acc.addNode(nodeContainer.head!!)
        println()
        acc.tail = nodeContainer.tail
        acc.tail?.next = null
        acc
    }.head
}