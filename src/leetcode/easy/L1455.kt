package leetcode.easy

import tools.checkResult

fun main() {
    checkResult(expected = 4, actual = isPrefixOfWord(sentence = "i love eating burger", searchWord = "burg"))
}

private fun isPrefixOfWord(sentence: String, searchWord: String): Int {
    val list = sentence.split(" ")
    for (i in list.indices) {
        val word = list[i]
        if (searchWord.length <= word.length && word.startsWith(searchWord)) {
            return i + 1
        }
    }
    return -1
}