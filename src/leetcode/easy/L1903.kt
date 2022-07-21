package leetcode.easy


fun main() {
    largestOddNumber("4206")
}

private fun largestOddNumber(num: String): String {
    var last = num.lastIndex
    while (last > -1) {
        if (num[last].toInt() and 1 == 1)
            break
        last--
    }
    if (last==-1)
        return ""
    return num.substring(0..last)
}
