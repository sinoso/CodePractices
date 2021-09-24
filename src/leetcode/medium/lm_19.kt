package leetcode.medium

import leetcode.testclass.ListNode

fun main() {
    fun ListNode.printAllN() {
        var next: ListNode? = this
        while (next != null) {
            print("${next.`val`} ")
            next = next.next
        }
        println()
    }
    removeNthFromEnd(ListNode(1), 1)?.printAllN()
    println()
    removeNthFromEnd(ListNode(1).also { it1 -> it1.next = ListNode(2) }, 2)?.printAllN()
    removeNthFromEnd(ListNode(1).also { it1 -> it1.next = ListNode(2) }, 1)?.printAllN()
    removeNthFromEnd(ListNode(1).also { it1 -> it1.next = ListNode(2).also { it2 -> it2.next = ListNode(3) } }, 3)?.printAllN()
    removeNthFromEnd(ListNode(1).also { it1 -> it1.next = ListNode(2).also { it2 -> it2.next = ListNode(3).also { it3 -> it3.next = ListNode(4) } } }, 4)?.printAllN()
    removeNthFromEnd(ListNode(1).also { it1 -> it1.next = ListNode(2).also { it2 -> it2.next = ListNode(3).also { it3 -> it3.next = ListNode(4).also { it4 -> it4.next = ListNode(5) } } } }, 4)?.printAllN()
    removeNthFromEnd(ListNode(1).also { it1 -> it1.next = ListNode(2).also { it2 -> it2.next = ListNode(3).also { it3 -> it3.next = ListNode(4).also { it4 -> it4.next = ListNode(5) } } } }, 2)?.printAllN()
}

// 처음이면?
//중간이면?
//끝이면?
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var left: ListNode? = head
    var right: ListNode? = left?.next
    if (right == null)
        return null
    else if (right.next == null)
        if (n == 1)
            head?.next = null
        else
            return head?.next
    for (i in 1 until n)
        right = right?.next
    if (right == null)
        return head?.next
    while (right?.next!=null){
        right = right.next
        left = left?.next
    }
    left?.next = left?.next?.next
    return head
}
//fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
//    var left: ListNode? = head
//    var right: ListNode? = head
//    for (i in 1..n)
//        right = right?.next
//    while (right != null) {
//        right = right.next
//        left = left?.next
//    }
//    if(head == left)
//        return head?.next
//    left?.next = left?.next?.next
//    return head
//}