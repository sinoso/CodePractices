package leetcode.easy

import java.util.*

fun main() {

}

class MinStack {
    private val allStack = Stack<Int>()
    private val minStack = Stack<Int>()

    fun push(`val`: Int) {
        allStack.add(`val`)
        if (minStack.isEmpty() || minStack.peek() >= `val`)
            minStack.push(`val`)
    }

    fun pop() {
        if (allStack.pop() == minStack.peek())
            minStack.pop()
    }

    fun top(): Int = allStack.peek()

    fun getMin(): Int = minStack.peek()
}
