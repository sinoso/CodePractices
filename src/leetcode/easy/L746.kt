package leetcode.easy

import printResult

fun main() {
    printResult(minCostClimbingStairs(intArrayOf(10, 15, 20)), 15)
    printResult(minCostClimbingStairs(intArrayOf(10, 8)), 8)
}

private fun minCostClimbingStairs(cost: IntArray): Int {
    val table = IntArray(cost.size + 1)
    for (i in 2..table.lastIndex) {
        table[i] = (table[i - 2] + cost[i - 2]).coerceAtMost(table[i - 1] + cost[i - 1])
    }
    return table.last()
}
