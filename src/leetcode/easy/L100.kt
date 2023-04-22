package leetcode.easy

import leetcode.testclass.TreeNode

fun main() {
    println(isSameTree(TreeNode(1).also {
        it.left = TreeNode(2)
    }, TreeNode(1).also {
        it.right = TreeNode(3)
    }))
    println(isSameTree(TreeNode(1).also {
        it.left = TreeNode(2)
        it.right = TreeNode(3)
    }, TreeNode(1).also {
        it.left = TreeNode(2)
        it.right = TreeNode(3)
    }))
}

private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean = when {
    p == null && q == null -> true
    p?.`val` != q?.`val` -> false
    p != null && q != null -> isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    else -> false
}

private fun isSameTree2(p: TreeNode?, q: TreeNode?): Boolean = when {
    p == null && q == null -> true
    p != null && q != null -> p.`val` == q.`val` && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    else -> false
}
