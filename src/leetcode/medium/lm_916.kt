package leetcode.medium

fun main() {
    println(
        wordSubsets(
            arrayOf("amazon", "apple", "facebook", "google", "leetcode"),
            arrayOf("e", "o")
        ).joinToString(",")
    )
    println(
        wordSubsets(
            arrayOf("amazon", "apple", "facebook", "google", "leetcode"),
            arrayOf("l", "e")
        ).joinToString(",")
    )
    println(
        wordSubsets(
            arrayOf("amazon", "apple", "facebook", "google", "leetcode"),
            arrayOf("e", "oo")
        ).joinToString(",") 
    )
}

inline fun <T, R : Comparable<R>> Iterable<T>.maxOf(selector: (T) -> R): R {
    val iterator = iterator()
    if (!iterator.hasNext()) throw NoSuchElementException()
    var maxValue = selector(iterator.next())
    while (iterator.hasNext()) {
        val v = selector(iterator.next())
        if (maxValue < v) {
            maxValue = v
        }
    }
    return maxValue
}

private fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
    var answer = words1.toList()

    var need = words2
        .map { it.groupBy { ch -> ch } }
        .map {
            it.entries
                .map { entry -> Pair(entry.key, entry.value.size) }
        }.flatten()
        .groupBy { it.first }
        .map { Pair(it.key, it.value.maxOf { value -> value.second }) }
    answer = answer.filter {
        for (pair in need) {
            if (it.toCharArray().filter { chInWord -> chInWord == pair.first }.size < pair.second)
                return@filter false
        }
        true
    }
    return answer
}

private fun wordSubsets2(words1: Array<String>, words2: Array<String>): List<String> {
    var answer = words1.toList()
    words2.forEach {
        val map = it.groupBy { ch -> ch }
        answer = answer.filter { word ->
            val subMap = word.groupBy { ch -> ch }
            var result = true
            for (entry in map) {
                if (result) {
                    val chInSub = subMap[entry.key]
                    result = chInSub != null && entry.value.size <= chInSub.size
                    if (!result) continue
                }
            }
            result
        }
    }
    return answer
}
