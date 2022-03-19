package leetcode.medium

import leetcode.testclass.TreeNode

fun main() {

}

fun sumEvenGrandparent(currentNode: TreeNode?, grandParent: Boolean = false, parent: Boolean = false): Int {
    currentNode ?: return 0
    var answer = 0
    if (grandParent)
        answer += currentNode.`val`
    val isThisEven = currentNode.`val` and 1 == 0
    answer += sumEvenGrandparent(currentNode.left, parent, isThisEven)
    answer += sumEvenGrandparent(currentNode.right, parent, isThisEven)
    return answer
}


private fun sumEvenGrandparent2(root: TreeNode?): Int {
    return check(grandParent = false, parent = false, root)
}

fun check(grandParent: Boolean, parent: Boolean, currentNode: TreeNode?): Int {
    currentNode ?: return 0
    var answer = 0
    if (grandParent)
        answer += currentNode.`val`
    val isThisEven = currentNode.`val` and 1 == 0
    answer += check(parent, isThisEven, currentNode.left)
    answer += check(parent, isThisEven, currentNode.right)
    return answer
}
