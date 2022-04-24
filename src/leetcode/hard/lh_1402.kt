package leetcode.hard

import printResult

fun main() {
    printResult(maxSatisfaction(intArrayOf(-1, -8, 0, 5, -9)), 14)
    printResult(maxSatisfaction(intArrayOf(4, 3, 2)), 20)
    printResult(maxSatisfaction(intArrayOf(-1, -4, -5)), 0)
}

private fun maxSatisfaction(satisfaction: IntArray): Int {
    satisfaction.sortDescending()
    var acc = 0
    var sum = 0
    var index = 0
    val size = satisfaction.size
    while (acc >= 0) {
        sum += acc
        if (index == size)
            break
        acc += satisfaction[index++]
    }
    return sum
}
// 각자리는 1 ~ 순으로 valueInArray * i 형태
// 이때 sorted된거에서 앞에서 자를 수있다.
/*
*    -9   -8    -1   0     5
     -9  -16    -3   0    25         -3     acc = -13
          -8    -2   0    20         10     acc = -4   - stop
                -1   0    15         14     acc = 4
                     0    10         10     acc = 5
                          5           5     acc = 5

* */
