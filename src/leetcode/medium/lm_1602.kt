package leetcode.medium

import leetcode.testclass.TreeNode
import java.util.*

fun main() {
    val node = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
        }
        right = TreeNode(3).apply {
            left = TreeNode(5)
            right = TreeNode(6)
        }
    }
    val node2 = TreeNode(3).apply {
        right = TreeNode(4).apply {
            left = TreeNode(2)
        }
    }
    println(findNearestRightNode(node, TreeNode(4))?.`val` ?: 0)
    println(findNearestRightNode(node2, TreeNode(2))?.`val` ?: 0)
}

private fun findNearestRightNode(root: TreeNode?, u: TreeNode?): TreeNode? {
    var currentQueue = LinkedList<TreeNode>() as Queue<TreeNode>
    var subQueue = LinkedList<TreeNode>() as Queue<TreeNode>
    currentQueue.add(root)
    while (currentQueue.isNotEmpty() || subQueue.isNotEmpty()) {
        val indexOfU = currentQueue.indexOfFirst { it.`val`==u!!.`val` }
        if (indexOfU != -1) {
            if (indexOfU != currentQueue.size - 1)
                return currentQueue.elementAt(indexOfU + 1)
            return null
        }
        while (currentQueue.isNotEmpty()) {
            currentQueue.poll().run {
                left?.let(subQueue::add)
                right?.let(subQueue::add)
            }
        }
        val temp = currentQueue
        currentQueue = subQueue
        subQueue = temp
    }
    return null
}
