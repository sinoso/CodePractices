package leetcode.medium

import leetcode.testclass.ListNode
import printResult

fun main() {
    printResult(swapNodes(ListNode.createByInts(7, 9, 6, 6, 7, 8, 3, 0, 9, 5), 5)?.joinAll() ?: "",
        ListNode.createByInts(7, 9, 6, 6, 8, 7, 3, 0, 9, 5).joinAll())
}


private fun swapNodes(head: ListNode?, k: Int): ListNode? {
    val map = HashMap<Int, ListNode>()
    var current = head
    var idx = 0
    while (current != null) {
        map[idx++] = current
        current = current.next
    }
    if (k == 1 || k == idx) {
        val front = map[0]!!
        val back = map[idx - 1]!!
        val preBack = map[idx - 2]?.let {
            it.next = front
        }
        back.next = front.next
        front.next = null
        return back
    }
    val front = map[k - 1]!!
    val preFront = map[k - 2]
    val back = map[idx - k]!!
    val preBack = map[idx - k - 1]
    preFront?.let { it.next = back }
    preBack?.let { it.next = front }
    val temp = front.next
    front.next = back.next
    back.next = temp
    return head
}
