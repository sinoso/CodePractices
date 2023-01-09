package leetcode.easy

import leetcode.testclass.TreeNode
import printResult

fun main() {

}

private fun preorderTraversal(root: TreeNode?): List<Int> {
    return search(root, mutableListOf())
}

private fun search(root: TreeNode?, list: MutableList<Int>): MutableList<Int> {
    root ?: return list
    list.add(root.`val`)
    search(root.left,list)
    search(root.right,list)
    return list
}
