package leetcode.medium

import java.util.*
import leetcode.testclass.Node

fun main() {

}

//19:05 ~ 19:17
private fun levelOrder(root: Node?): List<List<Int>> {
    val answerList = mutableListOf<MutableList<Int>>()
    var currentQueue: Queue<Node> = LinkedList()
    root?.let(currentQueue::add)
    while (currentQueue.isNotEmpty()) {
        val nextQueue: Queue<Node> = LinkedList()
        val currentDepthValues = mutableListOf<Int>()
        while (currentQueue.isNotEmpty()) {
            with(currentQueue.poll()!!) {
                currentDepthValues.add(`val`)
                if (children.isNotEmpty()) {
                    children.forEach{nextQueue.offer(it!!)}
                }
            }
        }
        currentQueue = nextQueue
        answerList.add(currentDepthValues)
    }
    return answerList
}
