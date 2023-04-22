package leetcode.easy


fun main() {
}

class MyStack() {
    private var topNode: Node? = null

    fun push(x: Int) {
        val newNode = Node(x)
        newNode.next = topNode
        topNode = newNode
    }

    fun pop(): Int {
        val value = topNode!!.value
        topNode = topNode!!.next
        return value
    }

    fun top(): Int = topNode!!.value

    fun empty(): Boolean = (topNode == null)

    private class Node(var value: Int, var next: Node? = null)

}
