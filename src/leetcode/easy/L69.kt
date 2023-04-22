package leetcode.easy

import printResult


fun main() {
    printResult(mySqrt(4), 2)
    printResult(mySqrt(0), 0)
    printResult(mySqrt(1), 1)
    printResult(mySqrt(8), 2)
}

private fun mySqrt(x: Int): Int {
    if(x<2)
        return x
    var left = 0
    var right = x / 2
    var median: Int
    var pow:Long
    while (left <= right) {
        median = (left + right) / 2
        pow = median * median.toLong()
        if(pow < x)
            left = median + 1
        else if(pow > x)
            right = median - 1
        else return median
    }
    return right
}
