package leetcode.easy

import leetcode.testclass.TreeNode
import java.util.*

fun main() {
    println(
        averageOfLevels(
            TreeNode.createByArray(
                arrayOf(
                    3,
                    9,
                    20,
                    null,
                    null,
                    15,
                    7
                )
            )
        ).joinToString(separator = ", ")
    )
}

// 00:16 ~ 00:25
private fun averageOfLevels(root: TreeNode?): DoubleArray {
    var currentQueue: Queue<TreeNode> = LinkedList()
    var nextQueue: Queue<TreeNode> = LinkedList()
    val answerList = mutableListOf<Double>()
    currentQueue.add(root)
    while (currentQueue.isNotEmpty()) {
        var sum = 0L
        var count = 0
        while (currentQueue.isNotEmpty()) {
            currentQueue.poll().let {
                it.left?.let(nextQueue::add)
                it.right?.let(nextQueue::add)
                sum += it.`val`
            }
            count++
        }
        currentQueue = nextQueue
        nextQueue = LinkedList()
        answerList.add(sum / count.toDouble())
    }
    return answerList.toDoubleArray()
}
