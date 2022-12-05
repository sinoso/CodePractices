package leetcode.easy

import leetcode.testclass.ListNode

fun main() {

}

private fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    var currentHead = head
    while (currentHead != null && currentHead.`val` == `val`) {
        currentHead = currentHead.next
    }
    var currentNode = currentHead
    while (currentNode!=null&&currentNode.next!=null){
        if (currentNode.next!!.`val`==`val`){
            currentNode.next = currentNode.next!!.next
        }else{
            currentNode = currentNode.next
        }
    }
    return currentHead
}
