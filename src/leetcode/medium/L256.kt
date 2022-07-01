package leetcode.medium


fun main() {
    minCost(arrayOf(intArrayOf(17, 2, 17), intArrayOf(16, 16, 5), intArrayOf(14, 3, 19)))
    minCost(arrayOf(intArrayOf(20, 18, 4), intArrayOf(9, 9, 10)))
}

private fun minCost(costs: Array<IntArray>): Int {
    for (index in 0 until costs.lastIndex) {
        val sorted = costs[index].indices.sortedBy { costs[index][it] }
        val smallest1st = sorted[0]
        val smallest2nd = sorted[1]
        for (currentIndex in costs[index].indices) {
            if (currentIndex == smallest1st) {
                costs[index + 1][currentIndex] += costs[index][smallest2nd]
                continue
            }
            costs[index + 1][currentIndex] += costs[index][smallest1st]
        }
    }
    return costs.last().fold(Int.MAX_VALUE) { acc, i -> acc.coerceAtMost(i) }
}
