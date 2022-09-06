package leetcode.medium

import leetcode.testclass.TreeNode

fun main() {

}

// 19:46 ~ 20:00
fun pruneTree(root: TreeNode?): TreeNode? {
    if (root == null)
        return null
    root.left = pruneTree(root.left)
    root.right = pruneTree(root.right)
    if (root.left == null && root.right == null && root.`val` == 0)
        return null
    return root
}
