package leetcode.medium

import leetcode.testclass.TreeNode

fun main() {
    findLeaves(TreeNode.createByInts(1, 2, 3, 4, 5))
}

val answerList = mutableListOf<MutableList<Int>>()
private fun findLeaves(root: TreeNode?): List<List<Int>> {
    search(root!!)
    return answerList
}

private fun search(root: TreeNode): Int {
    var currentDepth = 0
    root.left?.let { currentDepth = currentDepth.coerceAtLeast(search(it)) }
    root.right?.let { currentDepth = currentDepth.coerceAtLeast(search(it)) }
    if (answerList.size <= currentDepth)
        answerList.add((mutableListOf()))
    answerList[currentDepth].add(root.`val`)
    return currentDepth + 1
}


private fun findLeaves2(root: TreeNode?): List<List<Int>> {
    search2(root!!)
    return answerMap.entries.sortedBy { it.key }.map { it.value }
}

val answerMap = HashMap<Int, MutableList<Int>>()

fun search2(root: TreeNode): Int {
    var currentDepth = 0
    root.left?.let { currentDepth = currentDepth.coerceAtLeast(search(it)) }
    root.right?.let { currentDepth = currentDepth.coerceAtLeast(search(it)) }
    answerMap[currentDepth] = answerMap.getOrDefault(currentDepth, mutableListOf()).apply { add(root.`val`) }
    return currentDepth + 1
}
