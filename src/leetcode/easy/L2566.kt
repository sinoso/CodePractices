package leetcode.easy

fun main() {

}

private fun minMaxDifference(num: Int): Int {
    var target = 9
    val numString = num.toString()
    for (c in numString) {
        if (c != '9') {
            target = c - '0'
            break
        }
    }
    return numString.map { if (it - '0' == target) '9' else it }.joinToString("")
        .toInt() - numString.map { if (it - '0' == numString.first() - '0') '0' else it }.joinToString("").toInt()
}