package leetcode.easy

import leetcode.testclass.TreeNode

private fun checkTree(root: TreeNode?): Boolean = root!!.`val` == root.left!!.`val` + root.right!!.`val`
