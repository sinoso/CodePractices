package leetcode.testclass

class Node(var `val`:Int) {
    var next: Node? = null
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
    var children: List<Node?> = listOf()
    var random: Node? = null
}
