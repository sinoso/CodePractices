package leetcode.easy


fun main() {

}

private fun average(salary: IntArray): Double {
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    var sum = 0.0
    for (i in salary) {
        sum += i

        min = min.coerceAtMost(i)
        max = max.coerceAtLeast(i)
    }
    return (sum - min - max) / (salary.size-2)
}
