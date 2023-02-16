package leetcode.easy

fun main() {
}

private fun isSumEqual(firstWord: String, secondWord: String, targetWord: String): Boolean {
    fun getValue(s: String): Int {
        var value = 0
        for (i in s.indices) {
            value *= 10
            value += s[i] - 'a'
        }
        return value
    }
    return getValue(firstWord) + getValue(secondWord) == getValue(targetWord)
}