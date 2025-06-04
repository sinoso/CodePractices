package leetcode.easy

fun main() {
    numOfUnplacedFruits(intArrayOf(3, 6, 1), intArrayOf(6, 4, 7))
}

private fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
    val list = fruits.toMutableList()
    var basketIndex = 0
    loop@ while (list.isNotEmpty()) {
        if (baskets.lastIndex < basketIndex)
            return list.size
        for (i in list.indices) {
            if (baskets[basketIndex] >= list[i]) {
                list.removeAt(i)
                basketIndex++
                continue@loop
            }
        }
        basketIndex++
    }
    return 0
}