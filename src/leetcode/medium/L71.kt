package leetcode.medium

import java.util.*

fun main() {

}

private fun simplifyPath(path: String): String {
    val stack = Stack<String>()
    path.split("/").forEach {
        when (it) {
            ".", "" -> {
                return@forEach
            }
            ".." -> {
                if (stack.isNotEmpty())
                    stack.pop()
                return@forEach
            }
            else -> stack.push(it)
        }
    }
    return stack.toList().joinToString(separator = "/", prefix = "/")
}

