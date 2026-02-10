package leetcode.easy

fun main() {

}

private fun removeTrailingZeros(num: String): String {
    var lastIndex = num.lastIndex
    while (lastIndex >= 0) {
        if (num[lastIndex] != '0') {
            break
        }
        lastIndex--
    }
    if (lastIndex == -1)
        return num
    return num.substring(0,lastIndex + 1)
}