package leetcode.easy

import leetcode.testclass.TreeNode

fun main() {

}

// 01:15 ~ 01:26
private fun tree2str(root: TreeNode?): String =
    search(root).toString()


fun search(root: TreeNode?, sb: StringBuilder = StringBuilder()): StringBuilder {
    root ?: return sb
    sb.append(root.`val`)
    if (root.right != null || root.left != null) {
        sb.append('(')
        search(root.left, sb)
        sb.append(')')
    }
    if (root.right != null) {
        sb.append('(')
        search(root.right, sb)
        sb.append(')')
    }
    return sb
}
