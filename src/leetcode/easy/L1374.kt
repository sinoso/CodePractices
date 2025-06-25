package leetcode.easy

fun main() {

}


private fun generateTheString(n: Int): String = "a".repeat(n - 1) + if (n and 1 == 1) "a" else "b"