package leetcode.easy


fun main() {
//    dietPlanPerformance(intArrayOf(1, 2, 3, 4, 5), 1, 3, 3)
//    dietPlanPerformance(intArrayOf(6, 5, 0, 0), 2, 1, 5)
    dietPlanPerformance(intArrayOf(3, 2), 2, 0, 1)
}


private fun dietPlanPerformance(calories: IntArray, k: Int, lower: Int, upper: Int): Int {
    if (k == 1) {
        return calories.fold(0) { acc: Int, i: Int ->
            if (i > upper)
                acc + 1
            else if (i < lower)
                acc - 1
            else
                acc
        }
    }
    var count = 0
    var window = 0

    for (i in 0 until k - 1) {
        window += calories[i]
    }

    for (i in k - 1..calories.lastIndex) {
        window += calories[i]
        if (lower > window) {
            count--
        }
        if (upper < window) {
            count++
        }
        window -= calories[i - k + 1]
    }

    return count
}