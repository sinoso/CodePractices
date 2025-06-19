package leetcode.easy

import leetcode.testclass.ListNode

fun main() {

}

private fun gameResult(head: ListNode?): String {
    var currentNode = head
    var count = 0
    while (currentNode != null) {
        if (currentNode.`val` > currentNode.next!!.`val`){
            count++
        }else
            count--
        currentNode = currentNode.next!!.next
    }
    return when {
        count > 0 -> "Even"
        count < 0 -> "Odd"
        else -> "Tie"
    }
}