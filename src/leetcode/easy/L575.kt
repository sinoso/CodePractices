package leetcode.easy

fun main() {

}

private fun distributeCandies(candyType: IntArray): Int {
    val set = HashSet<Int>()
    val maxValue = candyType.size / 2
    for (i in candyType) {
        set.add(i)
        if (set.size >= maxValue) {
            return maxValue
        }
    }
    return set.size
}

private fun distributeCandies2(candyType: IntArray): Int =
    candyType.toHashSet()
        .count()
        .coerceAtMost(candyType.size / 2)