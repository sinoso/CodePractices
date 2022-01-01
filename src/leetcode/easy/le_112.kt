package leetcode.easy

import leetcode.testclass.TreeNode

fun main() {
    val node = TreeNode(5).apply {
        left = TreeNode(4).apply {
            left = TreeNode(11).apply {
                left = TreeNode(7)
                right = TreeNode(2)
            }
        }
        right = TreeNode(8).apply {
            left = TreeNode(13)
            right = TreeNode(4).apply {
                right = TreeNode(1)
            }
        }
    }
    val node2 = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }
    println(hasPathSum(node, 22))
    println(hasPathSum(node2, 5))
}

private fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    root ?: return false
    root.left?.let { it.`val` += root.`val` }
    root.right?.let { it.`val` += root.`val` }
    if (root.left == null && root.right == null)
        return root.`val` == targetSum
    val leftResult = hasPathSum(root.left, targetSum)
    val rightResult = hasPathSum(root.right, targetSum)
    return leftResult || rightResult
}
