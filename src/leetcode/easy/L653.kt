package leetcode.easy

import leetcode.testclass.TreeNode

fun main() {

}

private fun findTarget(root: TreeNode?, k: Int): Boolean {
    root ?: return false
    if (set.contains(k - root.`val`))
        return true
    set.add(root.`val`)
    return findTarget(root.left, k) || findTarget(root.right, k)
}
private val set = HashSet<Int>()
