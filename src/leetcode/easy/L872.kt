package leetcode.easy

import leetcode.testclass.TreeNode

fun main() {

}

private fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    val leafs1 = getLeafs(root1)
    val leafs2 = getLeafs(root2)
    if (leafs1!=leafs2)
        return false
    for (i in leafs1.indices){
        if (leafs1[i]!=leafs2[i])
            return false
    }
    return true
}

private fun getLeafs(root: TreeNode?, list: MutableList<Int> = mutableListOf()): MutableList<Int> {
    root?:return list
    if(root.left==null &&root.right==null){
        list.add(root.`val`)
    }
    getLeafs(root.left, list)
    getLeafs(root.right, list)
    return list
}