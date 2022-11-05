package leetcode.easy

fun main() {
}

private fun sumBase(n: Int, k: Int): Int =
    n.toString(k)
        .fold(0) { acc, c -> c - '0' + acc }
