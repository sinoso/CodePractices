package leetcode.medium

import leetcode.testclass.TreeNode

fun main() {
    val node = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
            right = TreeNode(5)
        }
        right = TreeNode(3).apply {
            left = TreeNode(6)
        }
    }
    println(countNodes(node))
}

private fun countNodes(root: TreeNode?): Int {
    var count = 0
    root?.let { count++ } ?: return count
    count += root.left?.let { countNodes(root.left) } ?: 0
    count += root.right?.let { countNodes(root.right) } ?: 0
    return count
}
