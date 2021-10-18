package leetcode.easy

fun main() {
    println(kidsWithCandies(intArrayOf(2, 3, 5, 1, 3), 3).joinToString())
}

private fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> =
        (candies.maxOrNull() ?: 0).run {
            candies.map { it + extraCandies >= this }
        }
