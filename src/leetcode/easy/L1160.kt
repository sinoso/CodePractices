package leetcode.easy

fun main() {

}

private fun countCharacters(words: Array<String>, chars: String): Int {
    val table = IntArray('z' - 'a' + 1)
    chars.forEach {
        table[it - 'a']++
    }
    var answer = 0

    Loop@ for (s in words) {
        val copyOfTable = table.copyOf()
        for (c in s) {
            val index = c - 'a'
            copyOfTable[index]--
            if (copyOfTable[index] < 0)
                continue@Loop
        }
        answer += s.length
    }
    return answer

}

private fun countCharacters2(words: Array<String>, chars: String): Int {
    var answer = 0

    val table = hashMapOf<Char, Int>()

    chars.forEach {
        table[it] = (table[it] ?: 0) + 1
    }
    for (s in words) {
        val countMap = s.groupingBy { it }.eachCount()
        val isAllContains = countMap.all { (char, count) -> (table[char] ?: 0) >= count }
        if (isAllContains)
            answer += s.length
    }
    return answer

}