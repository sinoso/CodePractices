package leetcode.easy

import printResult


fun main() {
    printResult(selfDividingNumbers(1, 22), listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22))
}

private fun selfDividingNumbers(left: Int, right: Int): List<Int> {
    val list = mutableListOf<Int>()
    for (i in left..right) {
        var flag = true
        var currentLeft = i
        while (currentLeft > 0 && flag) {
            val num = currentLeft % 10
            currentLeft /= 10
            flag = num != 0 && i % num == 0
        }
        if (flag)
            list.add(i)
    }
    return list
}
