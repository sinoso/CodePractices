package leetcode.easy

import leetcode.testclass.TreeNode

fun main() {

}

private fun sumOfLeftLeaves(root: TreeNode?): Int {
    return root?.let { sumLefts(root, false) } ?: 0
}

private fun sumLefts(node: TreeNode, isLeft: Boolean): Int {
    if (node.left == null && node.right == null)
        return if (isLeft) node.`val` else 0
    var sum = 0
    sum += node.left?.let { sumLefts(it, true) } ?: 0
    sum += node.right?.let { sumLefts(it, false) } ?: 0
    return sum
}
