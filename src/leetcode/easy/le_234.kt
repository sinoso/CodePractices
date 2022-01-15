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
    var left = 0
    var right = list.lastIndex
    while (left < right)
        if (list[left++] != list[right--])
            return false
    return true
}

private fun isPalindrome2(head: ListNode?): Boolean {
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
