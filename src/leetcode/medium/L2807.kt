package leetcode.medium

import leetcode.testclass.ListNode

fun main() {

}

private fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
    var leftNode = head
    while (leftNode?.next != null) {
        val rightNode = leftNode.next
        val gcd = gcd(leftNode.`val`, rightNode!!.`val`)
        val newNode = ListNode(gcd)
        leftNode.next = newNode
        newNode.next = rightNode
        leftNode = rightNode
    }
    return head
}

private tailrec fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
