package leetcode.easy

fun main() {
    println(frequencySort(intArrayOf(1, 1, 2, 2, 2, 3)).joinToString())
    println(frequencySort(intArrayOf(2, 3, 1, 3, 2)).joinToString())
    println(frequencySort(intArrayOf(-1, 1, -6, 4, 5, -6, 1, 4, 1)).joinToString())
}

private fun frequencySort(nums: IntArray): IntArray =
    nums.groupBy { it }
        .entries
        .sortedWith(
            compareBy<Map.Entry<Int, List<Int>>> { it.value.size }
                .thenByDescending { it.key })
        .flatMap { it.value }
        .toIntArray()
