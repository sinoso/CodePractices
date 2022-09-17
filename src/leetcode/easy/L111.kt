package leetcode.easy

import leetcode.testclass.TreeNode
import java.util.*

fun main() {

}

// 11:11 ~ 11:21
private fun minDepth(root: TreeNode?): Int {
    if (root == null)
        return 0
    if (root.left == root.right)
        return 1
    if (root.left == null)
        return minDepth(root.right) + 1
    if (root.right == null)
        return minDepth(root.left) + 1
    return minDepth(root.left).coerceAtMost(minDepth(root.right)) + 1
}

private fun minDepth2(root: TreeNode?): Int {
    var queue: Queue<TreeNode> = LinkedList()
    var queue2: Queue<TreeNode> = LinkedList()
    var depth = 0
    root?.let(queue::add)
    while (queue.isNotEmpty()) {
        depth++
        while (queue.isNotEmpty()) {
            with(queue.poll()!!) {
                if (left == right)
                    return depth
                left?.let(queue2::add)
                right?.let(queue2::add)
            }
        }
        val temp = queue
        queue = queue2
        queue2 = temp
    }
    return depth
}

