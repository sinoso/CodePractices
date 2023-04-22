package leetcode.easy

import leetcode.testclass.ListNode

fun main() {
    println(getDecimalValue(ListNode(1).apply { next = ListNode(0).apply { next = ListNode(1) } }))
}


private fun getDecimalValue(head: ListNode?): Int {
    var current: ListNode? = head
    var answer = 0
    while (current != null) {
        answer *= 2
        if (current.`val` == 1)
            answer += 1
        current = current.next
    }
    return answer
}
