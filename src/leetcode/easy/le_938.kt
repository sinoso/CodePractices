package leetcode.easy

import leetcode.testclass.TreeNode
import java.util.*

fun main() {
    println(rangeSumBST(TreeNode(10).also { node0 ->
        node0.left = TreeNode(5).also { node1 ->
            node1.left = TreeNode(3).also { node2 ->
                node2.left = TreeNode(1)
            }
            node1.right = TreeNode(7).also { node3 ->
                node3.left = TreeNode(6)
            }
        }
        node0.right = TreeNode(15).also { node4 ->
            node4.left = TreeNode(13)
            node4.right = TreeNode(18)
        }
    }, 6, 10))
}

private fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int { //recursive
    with(root) {
        this ?: return 0
        var sum = 0
        when {
            `val` < low ->
                sum += rangeSumBST(right, low, high)
            `val` in low..high -> {
                sum += `val`
                sum += rangeSumBST(left, low, high)
                sum += rangeSumBST(right, low, high)
            }
            `val` > high ->
                sum += rangeSumBST(left, low, high)
        }
        return sum
    }
}

private fun rangeSumBST_stack(root: TreeNode?, low: Int, high: Int): Int { //stack
    var answer = 0
    val stack: Stack<TreeNode> = Stack()
    stack.add(root)
    while (stack.size > 0)
        with(stack.pop()) {
            if (`val` in low..high)
                answer += `val`
            left?.let { stack.push(it) }
            right?.let { stack.push(it) }
        }
    return answer
}

private fun rangeSumBST_queue(root: TreeNode?, low: Int, high: Int): Int { //queue
    var answer = 0
    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)
    while (queue.size > 0)
        with(queue.poll()) {
            if (`val` in low..high)
                answer += `val`
            left?.let { queue.add(it) }
            right?.let { queue.add(it) }
        }
    return answer
}