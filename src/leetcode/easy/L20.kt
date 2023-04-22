package leetcode.easy

import java.util.*


fun main() {
    println(isValid("()"))
    println(isValid("()[]{}"))
    println(isValid("()("))
    println(isValid("()])"))
    println(isValid("("))
}

fun Stack<Char>.checkWithPeek(ch: Char): Boolean {
    return if (this.isEmpty() || peek() != ch) false
    else {
        pop()
        true
    }
}

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    val lastIdx = s.lastIndex
    stack.push(s[0])
    for (index in 1..lastIdx)
        when (s[index]) {
            ')' -> if (!stack.checkWithPeek('(')) return false
            ']' -> if (!stack.checkWithPeek('[')) return false
            '}' -> if (!stack.checkWithPeek('{')) return false
            else -> stack.push(s[index])
        }
    return stack.isEmpty()
}
