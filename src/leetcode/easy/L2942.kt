package leetcode.easy

fun main() {

}

private fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
    val list = mutableListOf<Int>()
    for (i in words.indices) {
        for (c in words[i]) {
            if (c == x) {
                list.add(i)
                break
            }
        }
    }
    return list
}

private fun findWordsContaining2(words: Array<String>, x: Char): List<Int> =
    words.withIndex()
        .filter { it.value.contains(x) }
        .map { it.index }