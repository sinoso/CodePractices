package leetcode.easy

fun main() {

}

private fun toArray(root: Node?): IntArray {
    var currentNode = root
    val list = mutableListOf<Int>()
    while (currentNode!=null){
        list.add(currentNode.`val`)
        currentNode = currentNode.next
    }
    return list.toIntArray()
}

private class Node(var `val`: Int) {
    var prev: Node? = null
    var next: Node? = null
}