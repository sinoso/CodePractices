package leetcode.easy

import leetcode.testclass.TreeNode
import printResult
import java.util.*


fun main() {
    printResult(increasingBST(
        TreeNode.createByArray(arrayOf(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9)))!!.valuesToString(),
        TreeNode.createByArray(arrayOf(1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7, null, 8, null, 9))!!
            .valuesToString())
}


private fun increasingBST(root: TreeNode?): TreeNode? {
    val heap = PriorityQueue<TreeNode>(kotlin.Comparator { o1, o2 ->
        if (o1.`val` > o2.`val`)
            return@Comparator 1
        else if (o1.`val` == o2.`val`)
            return@Comparator 0
        else
            return@Comparator -1
    })
    val queue = LinkedList<TreeNode?>() as Queue<TreeNode?>
    queue.add(root)
    heap.add(root)
    while (queue.isNotEmpty()) {
        val current = queue.poll() ?: continue
        fun addNode(node: TreeNode) {
            queue.add(node)
            heap.add(node)
        }
        current.left?.let(::addNode)
        current.right?.let(::addNode)
    }
    val head = heap.poll()
    var current = head
    while (heap.isNotEmpty()) {
        val preNode = current
        current.left = null
        current = heap.poll()
        preNode.right = current
        current.left = null
        current.right = null
    }
    return head
}
