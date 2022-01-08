package leetcode.medium

fun main() {
    println(topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2).joinToString(","))// 1,2
    println(topKFrequent(intArrayOf(2), 1).joinToString(","))//1
}

private fun topKFrequent(nums: IntArray, k: Int): IntArray =
    hashMapOf<Int, Int>()
        .apply { nums.forEach { this[it] = getOrDefault(it, 0) + 1 } }
        .entries
        .sortedBy { it.value }
        .takeLast(k)
        .map { it.key }
        .toIntArray()

private fun topKFrequent2(nums: IntArray, k: Int): IntArray {
    val answerMap = hashMapOf<Int, Int>()
    nums.forEach { answerMap[it] = answerMap.getOrDefault(it, 0) + 1 }
    return answerMap.entries.sortedBy { it.value }.takeLast(k).map { it.key }.toIntArray()
}
