package leetcode.medium

import leetcode.testclass.Node

fun main() {
    val node =
        Node(1).apply { children = listOf(Node(3).apply { children = listOf(Node(5), Node(6)) }, Node(2), Node(4)) }
    cloneTree(node)
}

private fun cloneTree(root: Node?): Node? =
    root?.let { Node(root.`val`).apply { children = root.children.map(::cloneTree) } } ?: root

private fun cloneTree2(root: Node?): Node? {
    root ?: return root
    return Node(root.`val`).apply {
        children = root.children.map(::cloneTree)
    }
}
