package leetcode.easy

fun main() {

}


private fun checkAlmostEquivalent(word1: String, word2: String): Boolean {
    val table = IntArray('z' - 'a' + 1)
    word1.forEach {
        table[it - 'a']++
    }
    word2.forEach {
        table[it - 'a']--
    }
    val range = -3..3
    for (diff in table) {
        if (diff !in range)
            return false
    }
    return true
}
