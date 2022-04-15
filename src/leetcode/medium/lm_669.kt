package leetcode.medium

import leetcode.testclass.TreeNode

fun main() {
    val head1 = TreeNode.createByArray(arrayOf(3, 1, 4, null, 2))
    head1?.printValues()
    trimBST(head1, 3, 4)
    head1?.printValues()

}

private fun trimBST(root: TreeNode?, low: Int, high: Int): TreeNode? {
    return when {
        root == null -> null
        root.`val` > high -> trimBST(root.left, low, high)
        root.`val` < low -> trimBST(root.right, low, high)
        else -> {
            root.left = trimBST(root.left, low, high)
            root.right = trimBST(root.right, low, high)
            root
        }
    }
}

private fun trimBST2(root: TreeNode?, low: Int, high: Int): TreeNode? {
    root ?: return root
    if (root.`val` < low)
        return trimBST(root.right, low, high)
    if (root.`val` > high)
        return trimBST(root.left, low, high)
    root.left = trimBST(root.left, low, high)
    root.right = trimBST(root.right, low, high)
    return root
}
