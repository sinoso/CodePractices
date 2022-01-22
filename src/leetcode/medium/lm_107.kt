package leetcode.medium

import leetcode.testclass.TreeNode
import java.util.*

fun main() {
    val node1 = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }
    val node2 = TreeNode(1)

    println(levelOrderBottom(node1).joinToString())
    println(levelOrderBottom(node2).joinToString())
    println(levelOrderBottom(null).joinToString())
}

private fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
    val queue = LinkedList<TreeNode?>() as Queue<TreeNode?>
    val answerList = mutableListOf<List<Int>>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val mList = mutableListOf<Int>()
        repeat(queue.size) {
            queue.poll()?.let {
                queue.add(it.left)
                queue.add(it.right)
                mList.add(it.`val`)
            }
        }
        if (mList.isNotEmpty())
            answerList.add(mList)
    }
    return answerList.reversed()
}
