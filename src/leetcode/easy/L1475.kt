package leetcode.easy

fun main() {

}

private fun finalPrices(prices: IntArray): IntArray {
    for (i in prices.indices) {
        for (j in (i + 1)..prices.lastIndex) {
            if (prices[i] >= prices[j]) {
                prices[i] -= prices[j]
                break
            }
        }
    }
    return prices
}