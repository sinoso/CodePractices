package leetcode.medium

import leetcode.testclass.TreeNode

fun main() {

}

private val set = hashSetOf<Int>()
private fun twoSumBSTs(root1: TreeNode?, root2: TreeNode?, target: Int): Boolean {
    var current = root1
    addAllNode(root1)
    while (current != null) {
        set.add(current.`val`)
        current = current.left

    }
    return checkNode(root2, target)
}

private fun addAllNode(root: TreeNode?) {
    if (root == null) return
    set.add(root.`val`)
    addAllNode(root.left)
    addAllNode(root.right)
}

private fun checkNode(root: TreeNode?, target: Int): Boolean {
    if (root == null) return false
    if (set.contains(target - root.`val`)) return true
    if (checkNode(root.left, target)) return true
    return checkNode(root.right, target)
}