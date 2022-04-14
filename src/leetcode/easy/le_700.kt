package leetcode.easy

import leetcode.testclass.TreeNode


fun main() {
}

private fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    root ?: return root
    if (root.`val` == `val`)
        return root
    if (root.`val` < `val`)
        return searchBST(root.right, `val`)
    else
        return searchBST(root.left, `val`)
}

private fun searchBST2(root: TreeNode?, `val`: Int): TreeNode? {
    root ?: return root
    if (root.`val` == `val`)
        return root
    root.left?.let { searchBST(it, `val`) }?.let { return it }
    root.right?.let { searchBST(it, `val`) }?.let { return it }
    return null
}
