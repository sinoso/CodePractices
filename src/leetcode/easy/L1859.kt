package leetcode.easy

fun main() {
    println(sortSentence("is2 sentence4 This1 a3"))
}

private fun sortSentence(s: String): String =
    s.split(" ").sortedBy { it.last() }.joinToString(" ") { it.slice(0 until it.lastIndex) }

