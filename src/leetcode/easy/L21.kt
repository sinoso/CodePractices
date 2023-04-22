package leetcode.easy

import leetcode.testclass.ListNode

fun main() {
    var list1 = ListNode(1).also { it1 -> it1.next = ListNode(3).also { it2 -> it2.next = ListNode(4) } }
    var list2 = ListNode(1).also { it1 -> it1.next = ListNode(2).also { it2 -> it2.next = ListNode(4) } }
    mergeTwoLists(list1, list2)
}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var left = l1
    var right = l2
    var head: ListNode? = null
    var pointer: ListNode?
    if (left != null && right != null) {
        when {
            left.`val` <= right.`val` -> {
                head = left
                left = left.next
            }
            left.`val` > right.`val` -> {
                head = right
                right = right.next
            }
        }
    } else if (right == null) {
        head = left
        left = left?.next
    } else {
        head = right
        right = right.next
    }
    pointer = head
    while (left != null || right != null) {
        if (left == null) {
            pointer?.next = right
            pointer = pointer?.next
            right = right?.next
            continue
        } else if (right == null) {
            pointer?.next = left
            pointer = pointer?.next
            left = left?.next
            continue
        }
        when {
            left.`val` <= right.`val` -> {
                pointer?.next = left
                pointer = pointer?.next
                left = left.next
            }
            left.`val` > right.`val` -> {
                pointer?.next = right
                pointer = pointer?.next
                right = right.next
            }
        }
    }
    return head
}

