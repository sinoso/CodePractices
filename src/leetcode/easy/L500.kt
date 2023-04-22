package leetcode.easy


fun main() {
    println(findWords(arrayOf("Hello", "Alaska", "Dad", "Peace")).joinToString(","))
}

private fun findWords(words: Array<String>): Array<String> {
    val answerList = mutableListOf<String>()
    words.forEach { origin ->
        val word = origin.toLowerCase()
        val firstCharOfSet = arrayOf("qwertyuiop", "asdfghjkl", "zxcvbnm").find { it.contains(word[0]) }!!
        for (ch in word)
            if (!firstCharOfSet.contains(ch))
                return@forEach
        answerList.add(origin)
    }
    return answerList.toTypedArray()
}
