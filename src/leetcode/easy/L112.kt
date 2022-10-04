package leetcode.easy

import leetcode.testclass.TreeNode
import printResult

fun main() {

    printResult(hasPathSum(TreeNode.createByInts(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1), 22), true)
    printResult(hasPathSum(TreeNode.createByInts(1, 2, 3), 5), false)
}

private fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    root ?: return false
    root.left?.let { it.`val` += root.`val` }
    root.right?.let { it.`val` += root.`val` }

    if (root.left == null && root.right == null)
        return root.`val` == targetSum

    return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum)
}
