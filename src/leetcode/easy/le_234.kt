package leetcode.easy

import leetcode.testclass.ListNode

fun main() {
    println(isPalindrome(ListNode.createByArray(intArrayOf(1, 2, 2, 1))))
    println(isPalindrome(ListNode.createByArray(intArrayOf(1, 2))))
}

private fun isPalindrome(head: ListNode?): Boolean {
    val list = mutableListOf<Int>()
    var current = head
    while (current != null) {
        list.add(current.`val`)
        current = current.next
    }
    var idx2 = list.lastIndex
    (0..(list.size - 1) / 2).forEach {
        if (list[it] != list[idx2--])
            return false
    }
    return true
}
