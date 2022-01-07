package leetcode.medium

import leetcode.testclass.ListNode

fun main() {
    val sol = Solution(ListNode(1).apply { next = ListNode(2).apply { next =  ListNode(3)} })
    println(sol.getRandom())
    val sol2 = Solution(ListNode(-1))
    println(sol2.getRandom())
}

class Solution(val head: ListNode?) {
    var last = 0
    fun getRandom(): Int {
        if (last == 0) {
            var current: ListNode? = head
            while (current != null) {
                current = current.next
                last++
            }
        }
        var current: ListNode? = head
        repeat((0 until last).random()) { current = current?.next }
        return current!!.`val`
    }
}
