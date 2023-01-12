package leetcode.easy

import leetcode.testclass.TreeNode
import printResult
import java.util.Deque
import java.util.LinkedList

fun main() {
}

private fun isSymmetric(root: TreeNode?): Boolean {
    val leftDeque: Deque<TreeNode?> = LinkedList()
    val rightDeque: Deque<TreeNode?> = LinkedList()
    leftDeque.push(root?.left)
    rightDeque.push(root?.right)
    while (leftDeque.isNotEmpty() || rightDeque.isNotEmpty()) {
        val left = leftDeque.poll()
        val right = rightDeque.poll()
        if (left?.`val` != right?.`val`)
            return false
        if (left != null && right != null) {
            leftDeque.push(left.left)
            leftDeque.push(left.right)
            rightDeque.push(right.right)
            rightDeque.push(right.left)
        }
    }
    return true
}