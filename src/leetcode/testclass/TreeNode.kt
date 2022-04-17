package leetcode.testclass

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    fun valuesList(): List<String> {
        val deque = LinkedList<TreeNode?>()
        deque.add(this)
        val list = mutableListOf<String>()
        while (deque.isNotEmpty()) {
            val node = deque.poll()
            if (node == null) {
                list.add("null")
                continue
            }
            list.add(node.`val`.toString())
            deque.add(node.left)
            deque.add(node.right)
        }
        return list
    }

    fun valuesToString() = valuesList().joinToString(", ", "[ ", " ]")
    fun printValues() = println(valuesToString())

    companion object {
        fun createByArray(array: Array<Int?>): TreeNode? {
            val nodeArray: Array<TreeNode?> = Array(array.size) { null }
            array.forEachIndexed { index, i ->
                i ?: return@forEachIndexed
                nodeArray[index] = TreeNode(i)
                val parentIndex = (index - 1) / 2
                if (index and 1 == 1)
                    nodeArray[parentIndex]!!.left = nodeArray[index]
                else
                    nodeArray[parentIndex]!!.right = nodeArray[index]
            }
            return if (nodeArray.isEmpty() || nodeArray.first() == null)
                null
            else {
                val head = nodeArray.first()
                if (head!!.left != null && head.left == head)
                    head.left = null
                head
            }
        }

        fun createByInts(vararg array: Int?): TreeNode? = createByArray(array.toList().toTypedArray())
    }
}
/*
*     0
*   1   2
*  3 4 5 6
* */
