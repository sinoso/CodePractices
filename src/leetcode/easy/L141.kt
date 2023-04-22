package leetcode.easy

import leetcode.testclass.ListNode

fun main() {
    var list1 = ListNode(3).also { it1 ->
        it1.next = ListNode(2).also { it2 ->
            it2.next = ListNode(0).also { it3 -> it3.next = ListNode(-4).apply { next = it1 } }
        }
    }
    println(hasCycle(list1))
    println(hasCycle(ListNode(3)))
    println(hasCycle(ListNode(1).also { it1 -> it1.next = ListNode(2).also { it2 -> it2.next = it1 } }))
}

private fun hasCycle(head: ListNode?): Boolean {
    var t = head
    var r = head
    do {
        t = t?.next ?: return false
        r = r?.next?.next ?: return false
    } while (t != r)
    return true
}

private fun hasCycle2(head: ListNode?): Boolean {
    var next = head
    val set = HashSet<ListNode?>()
    while (set.add(next)) {
        next = next?.next
    }
    if (next == null)
        return false
    return true
}
