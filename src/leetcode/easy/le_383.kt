package leetcode.easy

fun main() {

}

private fun canConstruct(ransomNote: String, magazine: String): Boolean {
//    val table = Array('a' - 'z' + 1) { 0 }
    val table = Array(26) { 0 }
    for (c in magazine)
        table[c - 'a']++
    for (c in ransomNote) {
        val index = c - 'a'
        table[index]--
        if (table[index] < 0)
            return false
    }
    return true
}

private fun canConstruct2(ransomNote: String, magazine: String): Boolean {
    val ransomNoteCount = ransomNote.groupingBy { it }.eachCount()
    val magazineCount = magazine.groupingBy { it }.eachCount()
    for (entry in ransomNoteCount.entries)
        if (entry.value > (magazineCount[entry.key] ?: 0))
            return false
    return true
}
