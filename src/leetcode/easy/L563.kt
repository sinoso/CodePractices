package leetcode.easy

import leetcode.testclass.TreeNode

fun main() {
    val node = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }
    println(findTilt(node))
}

private fun findTilt(root: TreeNode?): Int {
    return tiltAndValues(root).first
}

private fun tiltAndValues(root: TreeNode?): Pair<Int, Int> {
    if (root == null)
        return Pair(0, 0)
    val left = tiltAndValues(root.left)
    val right = tiltAndValues(root.right)
    val sumOfVal = left.second + right.second + root.`val`
    val tilt = left.second - right.second
    root.`val` = if (tilt < 0) tilt * -1 else tilt
    val sumOfTilt = left.first + right.first + root.`val`
    return Pair(sumOfTilt, sumOfVal)
}
