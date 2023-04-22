package leetcode.easy

import leetcode.testclass.TreeNode

fun main() {
}

private fun invertTree(root: TreeNode?): TreeNode? =
    root?.apply {
        val temp = left
        left = right
        right = temp
        invertTree(left)
        invertTree(right)
    }

