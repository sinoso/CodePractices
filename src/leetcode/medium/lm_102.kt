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

    val node3 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
        }
        right = TreeNode(3).apply {
            right = TreeNode(5)
        }
    }
    println(levelOrder(node1))
    println(levelOrder(node2))
    println(levelOrder(node3))
    println(levelOrder(null))
}

private fun levelOrder(root: TreeNode?): List<List<Int>> {
    root ?: return listOf()
    val result = mutableListOf<List<Int>>()
    var currentQueue: Queue<TreeNode> = LinkedList()
    var nextQueue: Queue<TreeNode> = LinkedList()
    currentQueue.add(root)
    result.add(listOf(root.`val`))
    var subList = mutableListOf<Int>()
    while (currentQueue.isNotEmpty()) {
        with(currentQueue.poll()) {

            listOfNotNull(left, right).map {
                nextQueue.add(it)
                subList.add(it.`val`)
            }
        }
        if (currentQueue.isEmpty()) {
            currentQueue = nextQueue
            nextQueue = LinkedList()
            if (subList.isNotEmpty())
                result.add(subList)
            subList = mutableListOf()
        }
    }
    return result
}
