package leetcode.medium

import leetcode.testclass.ListNode

fun main() {
    addTwoNumbers(ListNode.createByInts(7,2,4,3), ListNode.createByInts(5,6,4))
}

private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val l1Iterable = l1!!.getValList().listIterator()
    val l2Iterable = l2!!.getValList().listIterator()
    var current = 0
    var carry = false
    var lastNode: ListNode? = null
    while (l1Iterable.hasNext() || l2Iterable.hasNext()) {
        current = 0
        if (carry) current++
        carry = false
        if (l1Iterable.hasNext())
            current += l1Iterable.next()
        if (l2Iterable.hasNext())
            current += l2Iterable.next()
        if (current > 9) {
            current -= 10
            carry = true
        }
        val newNode = ListNode(current)
        lastNode?.let { newNode.next = lastNode }
        lastNode = newNode
    }
    if (carry){
       val newNode =  ListNode(1)
        newNode.next = lastNode
        lastNode = newNode
    }
    return lastNode
}

fun ListNode.getValList(): MutableList<Int> {
    return if (next == null)
        mutableListOf(`val`)
    else next!!.getValList().also { it.add(`val`) }
}
