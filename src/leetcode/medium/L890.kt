package leetcode.medium

import printResult

fun main() {
    printResult(findAndReplacePattern(arrayOf("abc", "deq", "mee", "aqq", "dkd", "ccc"), "abb"), listOf("mee", "aqq"))
}

// 02:10 ~ 02:37
private fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
    val answer = pattern.withIndex().fold(LinkedHashMap<Char, MutableList<Int>>()) { acc, value ->
        acc[value.value] = (acc[value.value] ?: mutableListOf()).apply { add(value.index) }
        acc
    }.values
    val answerList = mutableListOf<String>()

    words.forEach {
        val values = it.withIndex().fold(LinkedHashMap<Char, MutableList<Int>>()) { acc, value ->
            acc[value.value] = (acc[value.value] ?: mutableListOf()).apply { add(value.index) }
            acc
        }.values
        if (answer.size != values.size)
            return@forEach
        for (p in answer.zip(values)) {
            if (p.first.size != p.second.size)
                return@forEach
            for (i in p.first.indices) {
                if (p.first[i] != p.second[i])
                    return@forEach
            }
        }
        answerList.add(it)
    }
    return answerList
}
