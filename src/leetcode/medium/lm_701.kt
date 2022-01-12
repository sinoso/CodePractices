package leetcode.medium

import leetcode.testclass.TreeNode

fun main() {
    val node = TreeNode(4).apply {
        left = TreeNode(2).apply {
            left = TreeNode(1)
            right = TreeNode(3)
        }
        right = TreeNode(7)
    }
    println(insertIntoBST(node, 5))
}

private fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode =
    root?.also { findAndSet(root, `val`) } ?: TreeNode(`val`)

private fun insertIntoBST2(root: TreeNode?, `val`: Int): TreeNode? {
    root ?: return TreeNode(`val`)
    findAndSet(root, `val`)
    return root
}

fun findAndSet(root: TreeNode, `val`: Int) {
    if (root.`val` < `val`)
        root.right?.let { findAndSet(it, `val`) } ?: run { root.right = TreeNode(`val`) }
    else
        root.left?.let { findAndSet(it, `val`) } ?: run { root.left = TreeNode(`val`) }
}


