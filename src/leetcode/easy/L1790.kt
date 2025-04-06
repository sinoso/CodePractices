package leetcode.easy

fun main() {
    areAlmostEqual(s1 = "bank", s2 = "kanb")
}

private fun areAlmostEqual(s1: String, s2: String): Boolean {
    var diffCount = 0
    val diffTable = Array(2) { Pair('a', 'a') }
    for (i in s1.indices) {
        if (s1[i] != s2[i]) {
            if (diffCount > 1) {
                return false
            }
            diffTable[diffCount] = s1[i] to s2[i]
            diffCount++
        }
    }
    if (diffCount == 1)
        return false
    return diffTable[0].first == diffTable[1].second && diffTable[0].second == diffTable[1].first
}