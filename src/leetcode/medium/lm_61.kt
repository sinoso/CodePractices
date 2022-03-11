package leetcode.medium

import leetcode.testclass.ListNode

fun main() {
    fun test(vararg ints: Int, k: Int) {
        ListNode.createByArray(ints).also {
            print("-----\nbefore : ")
            it?.printAllN() ?: println()
            print("after  : ")
            rotateRight(it, k)?.printAllN() ?: println()
        }
    }
    test(1, 2, 3, 4, 5, k = 2)
    test(1, 2, k = 2)
    test(1, 2, k = 1)
    test(k = 0)
    test(1, k = 0)

}

private fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head == null || k == 0) return head
    var currentNode = head
    var preNode = head
    var count = 0
    while (currentNode?.next != null) {
        preNode = currentNode
        currentNode = currentNode.next
        count++
    }
    val lastNode = preNode
    currentNode = head
    val repeatTimes: Int
    if (count <= k) {// 전체 갯수는 k 이하이다.
        val needToFindNode = k % count
        if (needToFindNode == 0)
            return head
        repeatTimes = count - needToFindNode - 1
    } else { //전체 갯수는 k초과이다
        repeatTimes = count - k - 1
    }
    repeat(repeatTimes) {
        currentNode = currentNode!!.next
    }
    val newHead = currentNode!!.next
    currentNode!!.next = null
    lastNode!!.next = head
    return newHead
}

fun rotateRight2(head: ListNode?, k: Int): ListNode? {
    head ?: return head
    if (k == 0)
        return head
    var currentNode = head
    var preNode = head
    var count = 0
    while (currentNode != null) {
        preNode = currentNode
        currentNode = currentNode.next
        count++
    }
    val lastNode = preNode
    var newHead: ListNode? = null
    currentNode = head
    if (count <= k) {// k보다 전체 갯수가 적다
        val needToFindNode = k % count
        if (needToFindNode == 0)
            return head
        repeat(count - needToFindNode - 1) {
            currentNode = currentNode!!.next
        }
        newHead = currentNode!!.next
        currentNode!!.next = null
        lastNode!!.next = head
    } else { //전체 갯수는 k초과이다
        repeat(count - k - 1) {
            currentNode = currentNode!!.next
        }
        newHead = currentNode!!.next
        currentNode!!.next = null
        lastNode!!.next = head
    }
    return newHead
}
