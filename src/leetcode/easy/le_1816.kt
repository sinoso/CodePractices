package leetcode.easy

fun main() {
    println(truncateSentence("Hello how are you Contestant", 4))
}

private fun truncateSentence(s: String, k: Int): String =
    s.split(' ').take(k).joinToString(" ")

