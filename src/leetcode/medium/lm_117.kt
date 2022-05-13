package leetcode.medium

import java.util.*


fun main() {

}

private fun connect(root: Node?): Node? {
    val queue: Queue<Node> = LinkedList()
    root?.let(queue::add)
    while (queue.isNotEmpty()) {
        val currentSize = queue.size
        var lastNode: Node? = null
        repeat(currentSize) {
            queue.poll()
                .run {
                    left?.let(queue::add)
                    right?.let(queue::add)
                    lastNode?.let { it.next = this }
                    lastNode = this
                }
        }
    }
    return root
}

private fun connect2(root: Node?): Node? {
    root ?: return root
    val queue: Queue<Node> = LinkedList()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val currentSize = queue.size
        val currentList = mutableListOf<Node>()
        repeat(currentSize) {
            queue.poll()
                .run {
                    left?.let(queue::add)
                    right?.let(queue::add)
                    currentList.add(this)
                }
        }
        for (i in 0 until currentList.lastIndex) {
            currentList[i].next = currentList[i + 1]
        }
    }
    return root
}

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}
