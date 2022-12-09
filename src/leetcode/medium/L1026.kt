package leetcode.medium

import leetcode.testclass.TreeNode

fun main() {
    maxAncestorDiff(TreeNode.createByInts(8,3,10,1,6,null,14,null,null))
}

private fun maxAncestorDiff(root: TreeNode?, min: Int = 10000, max: Int = 0): Int {
    root ?: return max - min
    var nextMin = min
    var nextMax = max
    if (root.`val` < min) {
        nextMin = root.`val`
    }
    if (root.`val` > max) {
        nextMax = root.`val`
    }
    val left = maxAncestorDiff(
        root = root.left,
        min = nextMin,
        max = nextMax
    )
    val right = maxAncestorDiff(
        root = root.right,
        min = nextMin,
        max = nextMax
    )
    return left.coerceAtLeast(right)
}
