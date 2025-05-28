package leetcode.easy

fun main() {

}


private fun greatestLetter(s: String): String {
    val tableSize = 'z' - 'a' + 1
    val lowerTable = BooleanArray(tableSize)
    val upperTable = BooleanArray(tableSize)
    for (c in s) {
        if (c.isUpperCase()) {
            upperTable[c - 'A'] = true
        } else {
            lowerTable[c - 'a'] = true
        }
    }
    for (i in (tableSize - 1) downTo 0) {
        if (lowerTable[i] && upperTable[i])
            return ('A' + i).toString()
    }
    return ""
}