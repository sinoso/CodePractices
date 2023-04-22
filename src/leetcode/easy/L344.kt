package leetcode.easy

fun main() {
    println("HELLO".toCharArray().also { reverseString(it) })
}

private fun reverseString(s: CharArray): Unit {
    if (s.size == 1) return
    for (i in 0 until s.size / 2) {
        val temp = s[i]
        s[i] = s[s.lastIndex - i]
        s[s.lastIndex - i] = temp
    }
}