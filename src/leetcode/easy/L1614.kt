package leetcode.easy

import printResult


fun main() {
    printResult(maxDepth("(1+(2*3)+((8)/4))+1"),3)
}

private fun maxDepth(s: String): Int {
    var max = 0
    var count = 0
    for (c in s) {
        if (c == '(') {
            count++
            if (count > max)
                max = count
        } else if (c == ')')
            count--
    }
    return max
}
