package leetcode.easy

fun main() {

}


private fun maximumOddBinaryNumber(s: String): String =
    buildString {
        val count1 = s.count { it == '1' }
        repeat(count1 - 1) { append('1') }
        repeat(s.length - count1) { append('0') }
        append('1')
    }
private fun maximumOddBinaryNumber2(s: String): String {
    var count0 = 0
    var count1 = 0
    for (c in s) {
        if (c == '1')
            count1++
        else
            count0++
    }
    return "1".repeat(count1 - 1) + "0".repeat(count0) + "1"
}
