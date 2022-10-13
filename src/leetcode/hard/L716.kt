package leetcode.hard

import java.util.*

fun main() {
    val stk = MaxStack()
    stk.push(5) // [5] the top of the stack and the maximum number is 5.

    stk.push(1) // [5, 1] the top of the stack is 1, but the maximum is 5.

    stk.push(5) // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.

    stk.top() // return 5, [5, 1, 5] the stack did not change.

    stk.popMax() // return 5, [5, 1] the stack is changed now, and the top is different from the max.

    stk.top() // return 1, [5, 1] the stack did not change.

    stk.peekMax() // return 5, [5, 1] the stack did not change.

    stk.pop() // return 1, [5] the top of the stack and the max element is now 5.

    stk.top() // return 5, [5] the stack did not change.

}

class MaxStack {
    val queue = PriorityQueue(compareByDescending<Node> { it.value }.thenByDescending { it.index })
    val map = mutableSetOf<Node>()
    fun push(x: Int) {
        val newNode = Node(x)
        queue.offer(newNode)
        map.add(newNode)
    }

    fun pop(): Int {
        val needToRemove = map.last()
        map.remove(needToRemove)
        queue.remove(needToRemove)
        return needToRemove.value
    }

    fun top(): Int = map.last().value

    fun peekMax(): Int = queue.peek().value

    fun popMax(): Int {
        val needToRemove = queue.poll()
        map.remove(needToRemove)
        return needToRemove.value
    }

    class Node(val value: Int, val index: Int = number++) {
        companion object {
            var number: Int = 0
        }
    }
}
