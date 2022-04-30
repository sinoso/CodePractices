package leetcode.medium
import leetcode.testclass.TreeNode
import printResult
import java.util.*

fun main() {
    printResult(deepestLeavesSum(TreeNode.createByInts(1,2,3,4,5,null,6,7,null,null,null,null,8)), 15)

}

private fun deepestLeavesSum(root: TreeNode?): Int {
    if(root!!.left==null&&root.right==null)
        return root.`val`
    var currentQueue = LinkedList<TreeNode>()
    currentQueue.add(root)
    var nextQueue = LinkedList<TreeNode>()
    var sum = 0
    while (currentQueue.isNotEmpty()){
        sum =0
        while (currentQueue.isNotEmpty()){
            val currentNode = currentQueue.poll()
            currentNode.left?.let(nextQueue::add)
            currentNode.right?.let(nextQueue::add)
            sum +=currentNode.`val`
        }
        val temp = currentQueue
        currentQueue = nextQueue
        nextQueue = temp
    }
    return sum
}
