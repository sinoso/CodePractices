package leetcode.easy

import leetcode.testclass.TreeNode
import java.util.*

fun main() {
    val node = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
        }
        right = TreeNode(3)
    }
    val node2 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
        }
        right = TreeNode(3).apply {
            right = TreeNode(5)
        }
    }
    val node3 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
        }
        right = TreeNode(3)
    }
    val node4 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
            right = TreeNode(5)
        }
        right = TreeNode(3).apply {
            left = TreeNode(6)
            right = TreeNode(7)
        }
    }
    println(isCousins(node, 4, 3)) //f
    println(isCousins(node2, 5, 4))//t
    println(isCousins(node3, 2, 3))//f
    println(isCousins(node4, 5, 6))//t
}

private fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
    val queue = LinkedList<TreeNode?>() as Queue<TreeNode?>
    queue.add(root)
    while (queue.isNotEmpty()) {
        val indexOfX = queue.indexOfFirst { it?.`val` == x }
        val indexOfY = queue.indexOfFirst { it?.`val` == y }
        when {
            indexOfX != -1 && indexOfY != -1 -> return indexOfX / 2 != indexOfY / 2
            indexOfX != -1 || indexOfY != -1 -> return false
        }
        repeat(queue.size) {
            queue.poll()?.let {
                queue.add(it.left)
                queue.add(it.right)
            }
        }
    }
    return false
}

private fun isCousins2(root: TreeNode?, x: Int, y: Int): Boolean {
    var currentQueue = LinkedList<TreeNode?>() as Queue<TreeNode?>
    var subQueue = LinkedList<TreeNode?>() as Queue<TreeNode?>
    currentQueue.add(root)
    while (currentQueue.isNotEmpty() || subQueue.isNotEmpty()) {
        val indexOfX = currentQueue.indexOfFirst { it?.`val` == x }
        val indexOfY = currentQueue.indexOfFirst { it?.`val` == y }
        when {
            indexOfX != -1 && indexOfY != -1 -> return indexOfX / 2 != indexOfY / 2
            indexOfX != -1 || indexOfY != -1 -> return false
        }
        while (currentQueue.isNotEmpty()) {
            currentQueue.poll()?.let {
                subQueue.add(it.left)
                subQueue.add(it.right)
            }
        }
        val temp = currentQueue
        currentQueue = subQueue
        subQueue = temp
    }
    return false
}

private fun isCousins3(root: TreeNode?, x: Int, y: Int): Boolean {
    var currentQueue = LinkedList<TreeNode?>() as Queue<TreeNode?>
    var subQueue = LinkedList<TreeNode?>() as Queue<TreeNode?>
    val list = LinkedList<Int>()
    currentQueue.add(root)
    while (currentQueue.isNotEmpty() || subQueue.isNotEmpty()) {
        while (currentQueue.isNotEmpty()) {
            val currentNode = currentQueue.poll()
            val currentVal = currentNode?.let {
                subQueue.add(it.left)
                subQueue.add(it.right)
                it.`val`
            } ?: 0
            list.add(currentVal)
        }
        val containsX = list.contains(x)
        val containsY = list.contains(y)
        when {
            containsX && containsY -> return list.indexOf(x) / 2 != list.indexOf(y) / 2
            containsX || containsY -> return false
            else -> {
                val temp = currentQueue
                currentQueue = subQueue
                subQueue = temp
                list.clear()
            }
        }
    }
    return false
}
