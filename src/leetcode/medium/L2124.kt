package leetcode.medium

fun main() {
    checkString("abab")
}

// 21:20 ~
private fun checkString(s: String): Boolean {
    var lastValueB = false
    for (c in s) {
        if (c == 'b') {
            lastValueB = true
            continue
        }
        if (c == 'a' && lastValueB) return false
    }
    return true
}
