package leetcode.easy

fun main() {

}

private fun canPermutePalindrome(s: String): Boolean {
    val map = HashMap<Char, Int>()
    for (c in s) {
        map[c] = 1 + (map[c] ?: 0)
    }
    var count = 0
    for ((k, v) in map) {
        if (v and 1 == 1) {
            count++
            if (count == 2)
                return false
        }
    }
    return true
}

private fun canPermutePalindrome2(s: String): Boolean {
    val map = s.groupBy { it }
    var count = 0
    for ((k, v) in map) {
        if (v.size and 1 == 1) {
            count++
            if (count == 2)
                return false
        }
    }
    return true
}