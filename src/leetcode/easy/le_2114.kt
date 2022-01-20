package leetcode.easy

fun main() {
    println()
}

private fun mostWordsFound(sentences: Array<String>): Int {
    var max = 0
    for (sentence in sentences) {
        var count = 1
        for (ch in sentence)
            if (ch == ' ') count++
        max = if (count > max) count else max
    }
    return max
}

private fun mostWordsFound2(sentences: Array<String>): Int {
    var max = 0
    sentences.forEach {
        max = max.coerceAtLeast(it.count { it == ' ' } + 1)
    }
    return max
}

private fun mostWordsFound3(sentences: Array<String>): Int =
    sentences.map { it.count { it == ' ' } +1 }.maxOrNull() ?: 0

