package leetcode.medium

fun main() {
    println(topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), 2).joinToString())
    println(topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), 2).joinToString())
    println(
        topKFrequent(
            arrayOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"),
            4
        ).joinToString()
    )
}

private fun topKFrequent(words: Array<String>, k: Int): List<String> =
    HashMap<String, Int>()
        .apply { words.forEach { this[it] = getOrDefault(it, 0) + 1 } }
        .entries
        .asSequence()
        .sortedWith(compareByDescending<MutableMap.MutableEntry<String, Int>> { it.value }.thenBy { it.key })
        .take(k)
        .map { it.key }
        .toList()

private fun topKFrequent2(words: Array<String>, k: Int): List<String> {
    val hashmap = HashMap<String, Int>()
    words.forEach { hashmap[it] = hashmap.getOrDefault(it, 0) + 1 }
    return hashmap.entries.sortedWith(compareByDescending<MutableMap.MutableEntry<String, Int>> { it.value }.thenBy { it.key })
        .take(k).map { it.key }
}

