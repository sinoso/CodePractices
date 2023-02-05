package leetcode.medium

fun main() {
    findAnagrams(s = "cbaebabacd", p = "abc")
}

private fun findAnagrams(s: String, p: String): List<Int> {
    if (s.length<p.length)
        return listOf()
    fun isElementsSame(array1: Array<Int>, array2: Array<Int>): Boolean {
        for (i in array1.indices) {
            if (array1[i] != array2[i])
                return false
        }
        return true
    }

    val max = s.length - p.length
    val answer = mutableListOf<Int>()
    val templateTable = Array<Int>('z' - 'a' + 1) { 0 }
    val currentTable = Array<Int>('z' - 'a' + 1) { 0 }
    p.forEach {
        templateTable[it - 'a']++
    }
    val gap = p.length - 1
    for (i in 0 until gap) {
        currentTable[s[i] - 'a']++
    }
    for (i in 0..max) {
        currentTable[s[i + gap] - 'a']++
        if (isElementsSame(currentTable,templateTable)){
            answer+=i
        }
        currentTable[s[i] - 'a']--
    }
    return answer
}
