package leetcode.easy

fun main() {

}

private fun buyChoco(prices: IntArray, money: Int): Int {
    val min = prices.sorted().run { this[0] + this[1] }
    return if (min > money) money else money - min
}