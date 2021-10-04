package leetcode.medium

import leetcode.testclass.ListNode

fun main() {
    addTwoNumbers(ListNode(9), ListNode(9).also { it1 -> it1.next = ListNode(9) })?.printAllN()
}

/* l1, l2에서 각각 값을 받아온다.
노드가 null 이라면 무시한다.
최종 정지 조건은 다음 올림 0, 각노드가 null 일때이다.
*/
private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? = recursion(l1, l2, ListNode(0))

private fun recursion(l1: ListNode?, l2: ListNode?, list: ListNode): ListNode? {
    if (l1 == null && l2 == null && list.`val` == 0)
        return null
    val sum = list.`val` + (l1?.`val` ?: 0) + (l2?.`val` ?: 0)
    return list.apply {
        `val` = sum % 10
        next = recursion(l1?.next, l2?.next, ListNode(sum / 10))
    }
}

private fun recursion2(l1: ListNode?, l2: ListNode?, list: ListNode): ListNode? =
        if (l1 == null && l2 == null && list.`val` == 0) null
        else list.apply {
            (list.`val` + (l1?.`val` ?: 0) + (l2?.`val` ?: 0)).also {
                `val` = it % 10
                next = recursion(l1?.next, l2?.next, ListNode(it / 10))
            }
        }
