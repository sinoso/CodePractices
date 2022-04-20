package leetcode.medium

import leetcode.testclass.TreeNode

fun main() {
    val iterator = BSTIterator(TreeNode.createByInts(3,1,4,null,2))
    println(iterator.hasNext())
    println(iterator.next())
    println(iterator.hasNext())
    println(iterator.next())
    println(iterator.hasNext())
    println(iterator.next())
    println(iterator.hasNext())
    println(iterator.next())
    println(iterator.hasNext())
}

/*
["BSTIterator","hasNext","next","hasNext","next","hasNext","next","hasNext","next","hasNext"]
[[[3,1,4,null,2]],[],[],[],[],[],[],[],[],[]]
* */
class BSTIterator(root: TreeNode?) {

    var currentRoot: TreeNode? = root

    fun next(): Int {
        var currentNode = currentRoot!!
        var preNode: TreeNode = currentNode
        var isLeftNode = true
        while (currentNode.left != null || currentNode.right != null) {
            if (currentNode.left != null) {
                isLeftNode = true
                preNode = currentNode
                currentNode = currentNode.left!!
            } else
                break
        }
        if (currentNode == currentRoot) {
            val value = currentNode.`val`
            currentRoot = currentNode.right
            return value
        }
        if (isLeftNode)
            preNode.left = currentNode.right
        else
            preNode.right = currentNode.right
        if (currentNode == currentRoot)
            currentRoot = null
        return currentNode.`val`
    }

    fun hasNext(): Boolean = currentRoot != null

}
