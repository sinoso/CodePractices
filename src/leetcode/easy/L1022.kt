package leetcode.easy

import leetcode.testclass.TreeNode

fun main() {
    val node = TreeNode(1).apply {
        left = TreeNode(0).apply {
            left = TreeNode(0)
            right = TreeNode(1)
        }
        right = TreeNode(1).apply {
            left = TreeNode(0)
            right = TreeNode(1)
        }
    }
    println(sumRootToLeaf(node))
}

private fun sumRootToLeaf(root: TreeNode?): Int =
    with(root) {
        this ?: return 0
        if (left == null && right == null)
            return `val`
        left?.let { it.`val` += this.`val` shl 1 }
        right?.let { it.`val` += this.`val` shl 1 }
        val leftValues = sumRootToLeaf(left)
        val rightValues = sumRootToLeaf(right)
        leftValues + rightValues
    }

