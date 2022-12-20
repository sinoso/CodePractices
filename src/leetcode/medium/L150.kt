package leetcode.medium

import java.util.*

fun main() {

}

private fun evalRPN(tokens: Array<String>): Int =
    tokens.fold(Stack<Int>()) { acc, s ->
        acc.apply {
            when (s) {
                "+" -> push(pop().let { pop() + it })
                "-" -> push(pop().let { pop() - it })
                "/" -> push(pop().let { pop() / it })
                "*" -> push(pop().let { pop() * it })
                else -> {
                    push(s.toInt())
                }
            }
        }
    }.pop()

private fun evalRPN2(tokens: Array<String>): Int =
    with(Stack<Int>()) {
        for (s in tokens) {
            when (s) {
                "+" -> push(pop().let { pop() + it })
                "-" -> push(pop().let { pop() - it })
                "/" -> push(pop().let { pop() / it })
                "*" -> push(pop().let { pop() * it })
                else -> {
                    push(s.toInt())
                }
            }
        }
        return@with pop()
    }

