package leetcode.medium

import leetcode.testclass.TreeNode
import printResult

fun main() {
    printResult(kthSmallest(TreeNode.createByInts(5, 3, 6, 2, 4, null, null, 1), 3), 3)
    printResult(kthSmallest(TreeNode.createByInts(3, 1, 4, null, 2), 1), 1)
    printResult(kthSmallest(TreeNode.createByInts(0), 1), 0)
    printResult(kthSmallest(TreeNode.createByInts(1, 0, 2), 1), 0)
    printResult(kthSmallest(TreeNode.createByInts(1, null, 2), 2), 2)
}

private fun kthSmallest(root: TreeNode?, k: Int): Int {
    root ?: return -10001
    var nodesUnderParent = -1
    
    val smallerThanRoot = kthSmallest(root.left, k)
    if (smallerThanRoot >= 0)
        return smallerThanRoot
    if (smallerThanRoot != -10001)
        nodesUnderParent += smallerThanRoot

    if (k == -nodesUnderParent)
        return root.`val`

    val largerThanRoot = kthSmallest(root.right, k + nodesUnderParent)
    if (largerThanRoot != -10001)
        nodesUnderParent += largerThanRoot
    if (largerThanRoot >= 0)
        return largerThanRoot

    return nodesUnderParent
}
