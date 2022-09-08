package leetcode.easy

import leetcode.testclass.TreeNode

fun main() {

}

// 15:30 ~ 15:53
private fun inorderTraversal(root: TreeNode?): List<Int> {
    return search(root, mutableListOf())
}

private fun search(root: TreeNode?, list: MutableList<Int>): List<Int> {
    root ?: return list
    search(root.left, list)
    list.add(root.`val`)
    search(root.right, list)
    return list
}
