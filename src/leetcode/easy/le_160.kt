package leetcode.easy

import leetcode.testclass.ListNode

fun main() {

}

private fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    headA ?: return null
    headB ?: return null
    val set = HashSet<Int>()
    var currentNode = headA
    while (currentNode != null) {
        set.add(currentNode.hashCode())
        currentNode = currentNode.next
    }
    currentNode = headB
    while (currentNode != null) {
        if (set.contains(currentNode.hashCode()))
            break
        currentNode = currentNode.next
    }
    return currentNode
}
