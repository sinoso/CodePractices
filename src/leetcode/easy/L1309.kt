package leetcode.easy

fun main() {

}

private fun freqAlphabets(s: String): String {
    val sb = StringBuilder()
    var i = s.lastIndex
    while (i >= 0) {
        val c: Char
        if (s[i] == '#') {
            c = 'j' + (s[i - 2] - '1') * 10 + (s[i - 1] - '1') + 1
            i -= 3
        } else {
            c = 'a' + (s[i] - '1')
            i--
        }
        sb.insert(0, c)
    }
    return sb.toString()
}
