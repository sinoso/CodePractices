package leetcode.medium

import leetcode.testclass.TreeNode

fun main() {

}

private fun averageOfSubtree(root: TreeNode?): Int {
    return search(root)!!.answer
}

private fun search(root: TreeNode?): AverageOfSubtreeResult? {
    root ?: return null
    val leftResult = search(root.left)
    val rightResult = search(root.right)
    val sum = (leftResult?.sum ?: 0) + (rightResult?.sum ?: 0) + root.`val`
    val count = (leftResult?.count ?: 0) + (rightResult?.count ?: 0) + 1
    val answer = (leftResult?.answer ?: 0) + (rightResult?.answer ?: 0) + if (sum / count == root.`val`) 1 else 0
    return AverageOfSubtreeResult(sum, count, answer)
}

data class AverageOfSubtreeResult(val sum: Int, val count: Int, val answer: Int)

// top-> down 으로 내려간다.
// down -> top 으로 데이터를 끌어 올린다.
// 필요한 정보는? 이전까지의 합, 몇개나 있었는지 이전에 해당 되는 것들은 몇개인지? -> Triple
