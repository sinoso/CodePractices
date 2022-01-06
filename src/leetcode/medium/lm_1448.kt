package leetcode.medium

import leetcode.testclass.TreeNode

//
fun main() {
    val node = TreeNode(3).apply {
        left = TreeNode(1).apply {
            left = TreeNode(3)
        }
        right = TreeNode(4).apply {
            left = TreeNode(1)
            right = TreeNode(5)
        }
    }
    println(goodNodes(node))
    val node2 = TreeNode(3).apply {
        left = TreeNode(3).apply {
            left = TreeNode(4)
            right = TreeNode(2)
        }
    }
    println(goodNodes(node2))
    println(goodNodes(null))
}

private fun goodNodes(root: TreeNode?): Int {
    root ?: return 0
    val left = find(root.left, root.`val`)
    val right = find(root.right, root.`val`)
    return left + right + 1
}

private fun find(root: TreeNode?, maxRoot: Int): Int {
    root ?: return 0
    val currentMax = maxRoot.coerceAtLeast(root.`val`)
    val current = if (root.`val` == currentMax) 1 else 0
    val left = find(root.left, currentMax)
    val right = find(root.right, currentMax)
    return current + left + right
}
