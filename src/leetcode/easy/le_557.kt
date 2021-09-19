package leetcode.easy

fun main() {
    println(reverseWords("Let's take LeetCode contest"))
}

fun reverseWords(s: String): String =
        s.split(" ").joinToString(" ") { it.reversed() }
