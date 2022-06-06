package leetcode.medium

import leetcode.testclass.TreeNode

fun main() {
    bstToGst(TreeNode.createByInts(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8))
}

private fun bstToGst(root: TreeNode?): TreeNode? {
    change(root!!)
    return root
}

fun change(root: TreeNode, value: Int = 0): Int {
    root.`val` += root.right?.let { change(it, value) } ?: value
    return root.left?.let { change(it, root.`val`) } ?: root.`val`
}

