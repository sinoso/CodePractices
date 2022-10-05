package leetcode.medium

import leetcode.testclass.TreeNode

fun main() {

}

private fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
    root ?: return root
    if (depth == 1)
        return TreeNode(`val`).apply { left = root }
    if (depth != 2) {
        addOneRow(root.left, `val`, depth - 1)
        addOneRow(root.right, `val`, depth - 1)
        return root
    }
    root.left = TreeNode(`val`).apply { left = root.left }
    root.right = TreeNode(`val`).apply { right = root.right }
    return root
}
