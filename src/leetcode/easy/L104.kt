package leetcode.easy

import leetcode.testclass.TreeNode
import printResult

fun main() {
    val node1 = TreeNode(3).apply {
        left = TreeNode(6)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }
    printResult(maxDepth(node1), 3)
}

private fun maxDepth(root: TreeNode?, depth: Int = 0): Int =
    root?.let { maxDepth(it.left, depth + 1).coerceAtLeast(maxDepth(it.right, depth + 1)) } ?: depth


private fun maxDepth2(root: TreeNode?, depth: Int = 0): Int {
    root ?: return depth
    val leftDepth = maxDepth(root.left, depth + 1)
    val rightDepth = maxDepth(root.right, depth + 1)
    return leftDepth.coerceAtLeast(rightDepth)
}
