package leetcode.easy

import leetcode.testclass.TreeNode
import printResult
import java.util.*

fun main() {
    printResult(getLonelyNodes(TreeNode.createByInts(1, 2, 3, null, 4)), listOf(4))
}

private fun getLonelyNodes(root: TreeNode?): List<Int> {
    val queue = LinkedList<TreeNode>()
    queue.offer(root!!)
    val answerList = mutableListOf<Int>()
    while (queue.isNotEmpty()) {
        val current = queue.poll()
        current.right?.let {
            queue.add(it)
            if (current.left == null)
                answerList.add(it.`val`)
        }
        current.left?.let {
            queue.add(it)
            if (current.right == null)
                answerList.add(it.`val`)
        }
    }
    return answerList
}
