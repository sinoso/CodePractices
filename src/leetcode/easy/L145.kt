package leetcode.easy

import leetcode.testclass.TreeNode


fun main() {

}

private fun postorderTraversal(root: TreeNode?): List<Int> {
    val answer = mutableListOf<Int>()
    dfs(answer, root)
    return answer
}

private fun dfs(list: MutableList<Int>, node: TreeNode?) {
    node?: return
    dfs(list, node.left)
    dfs(list, node.right)
    list.add(node.`val`)
}