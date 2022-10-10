package leetcode.easy

import leetcode.testclass.TreeNode


fun main() {

}

private fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    val currentHead = (root1 ?: root2) ?: return root1
    currentHead.apply { `val` = (root1?.`val` ?: 0) + (root2?.`val` ?: 0) }
    root1?.left = mergeTrees(root1?.left, root2?.left)
    root1?.right = mergeTrees(root1?.right, root2?.right)
    return currentHead
}
