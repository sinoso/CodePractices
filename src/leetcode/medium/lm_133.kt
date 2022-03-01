package leetcode.medium

import leetcode.testclass.Node
import java.util.*

fun main() {
    cloneGraph(null)
}

private fun cloneGraph(node: Node?): Node? {
    node ?: return null
    val visitedSet = hashSetOf<Int>()
    val newNodeMap = HashMap<Int, Node>()
    val leftNodeQueue = (LinkedList<Node>() as Queue<Node>).apply { add(node) }
    val newReturnNode = Node(node.`val`).also { newNodeMap[it.`val`] = it }
    while (!leftNodeQueue.isEmpty()) {
        val oldCurrentNode = leftNodeQueue.poll()
        if (visitedSet.contains(oldCurrentNode.`val`))
            continue
        visitedSet.add(oldCurrentNode.`val`)
        leftNodeQueue.addAll(oldCurrentNode.neighbors)
        val newCurrentNode =
            newNodeMap[oldCurrentNode.`val`] ?: Node(oldCurrentNode.`val`).also { newNodeMap[it.`val`] = it }
        for (oldNeighborNode in oldCurrentNode.neighbors)
            oldNeighborNode?.let {
                newCurrentNode.neighbors.add(newNodeMap[it.`val`]
                    ?: Node(it.`val`).also { new -> newNodeMap[new.`val`] = new })
            }
    }
    return newReturnNode
}

private fun cloneGraph2(node: Node?): Node? {
    node ?: return null
    val visitedSet = hashSetOf<Int>()
    val newNodeMap = HashMap<Int, Node>()
    val leftNodeQueue = LinkedList<Node>() as Queue<Node>
    leftNodeQueue.add(node)
    val newReturnNode = Node(node.`val`).also { newNodeMap[it.`val`] = it }
    while (!leftNodeQueue.isEmpty()) {
        val oldCurrentNode = leftNodeQueue.poll()
        val numberOfNode = oldCurrentNode.`val`
        if (visitedSet.contains(numberOfNode))
            continue
        visitedSet.add(numberOfNode)
        leftNodeQueue.addAll(oldCurrentNode.neighbors)
        val newCurrentNode =
            newNodeMap[numberOfNode] ?: Node(numberOfNode).also { newNodeMap[it.`val`] = it }
        for (oldNeighborNode in oldCurrentNode.neighbors) {
            oldNeighborNode ?: continue
            val neighborNumber = oldNeighborNode.`val`
            val newNeighbor =
                newNodeMap[neighborNumber] ?: Node(neighborNumber).also { newNodeMap[it.`val`] = it }
            newCurrentNode.neighbors.add(newNeighbor)
        }
    }
    return newReturnNode
}

private fun cloneGraph3(node: Node?): Node? {
    node ?: return null
    val visitedArray = Array(101) { false }
    val newNodeArray = Array(101, ::Node)
    val leftNodeQueue = LinkedList<Node>() as Queue<Node>
    val returnNode = newNodeArray[node.`val`]
    leftNodeQueue.add(node)

    while (!leftNodeQueue.isEmpty()) {
        val oldCurrentNode = leftNodeQueue.poll()
        if (visitedArray[oldCurrentNode.`val`])
            continue
        leftNodeQueue.addAll(oldCurrentNode.neighbors)
        val newCurrentNode = newNodeArray[oldCurrentNode.`val`]
        visitedArray[oldCurrentNode.`val`] = true

        for (oldNeighborNode in oldCurrentNode.neighbors) {
            oldNeighborNode ?: continue
            newCurrentNode.neighbors.add(newNodeArray[oldNeighborNode.`val`])
        }
    }
    return returnNode
}
