package leetcode.easy

import leetcode.testclass.ListNode
fun main() {

}

private fun frequenciesOfElements(head: ListNode?): ListNode? {
    val table = HashMap<Int, Int>()
    var currentNode = head
    while (currentNode != null) {
        table[currentNode.`val`] = (table[currentNode.`val`] ?: 0) + 1
        currentNode = currentNode.next
    }
    val list = table.entries
        .sortedByDescending { it.key }
        .map { ListNode(it.value) }
    list.reduce { acc, listNode ->
        listNode.next = null
        acc.next = listNode
        listNode
    }
    return list.first()
}