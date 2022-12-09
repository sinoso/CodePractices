package leetcode.easy

fun main() {

}

private fun getLucky(s: String, k: Int): Int {
    var currentValue = s.map { it - 'a' + 1 }.joinToString("")
    repeat(k) {
        currentValue = currentValue.fold(0) { acc, c -> acc + (c - '0') }.toString()
    }
    return currentValue.toInt()
}
