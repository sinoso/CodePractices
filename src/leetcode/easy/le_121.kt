package leetcode.easy


fun main() {
    println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    println(maxProfit(intArrayOf(2, 4, 1)))
}

private fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0
    var minPrice = Int.MAX_VALUE
    for (i in prices.indices)
        if (prices[i] < minPrice)
            minPrice = prices[i]
        else
            maxProfit = maxProfit.coerceAtLeast(prices[i] - minPrice)
    return maxProfit
}
