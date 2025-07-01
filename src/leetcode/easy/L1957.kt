package leetcode.easy

fun main() {

}

private fun makeFancyString(s: String): String = buildString {
    var lastChar = 'a' - 1
    var count = 0
    for (c in s) {
        if (lastChar == c && count >= 2) {
            continue
        }
        if (lastChar != c) {
            lastChar = c
            count = 1
        } else {
            count++
        }
        append(c)
    }
}