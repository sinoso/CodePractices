package leetcode.medium

import leetcode.testclass.ListNode
import printResult
import java.util.Arrays

fun main() {
    printResult(pairSum(ListNode.createByInts(5, 4, 2, 1)), 6)
}

private fun pairSum(head: ListNode?): Int {
    var fast = head!!.next
    var slow = head
    var pre = slow
    //find twin's tail
    while (fast!=null){
        pre = slow
        slow = slow?.next
        fast = fast.next?.next
    }
    //reverse twins
    val twinEnd = pre!!.next
    pre.next = null
    var current = twinEnd
    var nextNode: ListNode?
    pre = null
    while (current!=null){
        nextNode = current.next
        current.next = pre
        pre = current
        current = nextNode
    }
    //find max
    val twinStart = pre
    var answer = 0
    var currentNode = head
    var currentTwin: ListNode? = twinStart!!
    while (currentNode!=null){
        answer = answer.coerceAtLeast(currentNode.`val`+currentTwin!!.`val`)
        currentNode = currentNode.next
        currentTwin = currentTwin.next
    }
    return answer
}
private fun pairSum2(head: ListNode?): Int {
    var current = head
    val list = mutableListOf<Int>()
    while (current != null) {
        list.add(current.`val`)
        current = current.next
    }
    val listHalf = list.lastIndex / 2
    val lastIndex = list.lastIndex
    var answer = 0
    for (i in 0..listHalf)
        answer = answer.coerceAtLeast(list[i] + list[lastIndex - i])
    return answer
}


// 0 1 2 3 4 5
