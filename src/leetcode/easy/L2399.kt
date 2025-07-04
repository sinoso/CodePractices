package leetcode.easy


fun main() {

}

private fun checkDistances(s: String, distance: IntArray): Boolean {
    for (indexOfString in s.indices) {
        val tableIndex = s[indexOfString] - 'a'
        if (distance[tableIndex] < 0) {
            if (indexOfString + distance[tableIndex] != 0)
                return false
        } else {
            distance[tableIndex] = -distance[tableIndex] - indexOfString - 1
        }
    }
    return true
}

private fun checkDistances2(s: String, distance: IntArray): Boolean {
    val checkTable = BooleanArray('z' - 'a' + 1)
    for (indexOfString in s.indices) {
        val tableIndex = s[indexOfString] - 'a'
        if (checkTable[tableIndex]) {
            if (indexOfString - distance[tableIndex] != 0)
                return false
        } else {
            checkTable[tableIndex] = true
            distance[tableIndex] += indexOfString + 1
        }
    }
    return true
}