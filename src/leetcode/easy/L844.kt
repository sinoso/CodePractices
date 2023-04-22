package leetcode.easy
import java.util.*

fun main() {
    println(backspaceCompare("ab#c", "ad#c"))
    println(backspaceCompare(s = "ab##", t = "c#d#"))
    println(backspaceCompare(s = "a##c", t = "#a#c"))
    println(backspaceCompare(s = "a#c", t = "b"))
}

private fun backspaceCompare(s: String, t: String): Boolean {
    val sStack = Stack<Char>().apply {
        s.forEach {
            if (it == '#') {
                if (isNotEmpty()) pop()
            } else push(it)
        }
    }
    val tStack = Stack<Char>().apply {
        t.forEach {
            if (it == '#') {
                if (isNotEmpty()) pop()
            } else push(it)
        }
    }
    while (sStack.isNotEmpty() && tStack.isNotEmpty())
        if (sStack.pop() != tStack.pop())
            return false

    if (sStack.isNotEmpty() || tStack.isNotEmpty())
        return false
    return true
}
