package leetcode.easy

fun main() {

}

private fun sortString(s: String): String {
    val table = IntArray('z' - 'a' + 1)
    for (c in s) {
        table[c - 'a']++
    }
    val sb = StringBuilder(s.length)
    while (sb.length < s.length) {
        for (i in table.indices) {
            if (table[i] != 0) {
                sb.append('a' + i)
                table[i]--
            }
        }
        for (i in table.indices.reversed()) {
            if (table[i] != 0) {
                sb.append('a' + i)
                table[i]--
            }
        }
    }
    return sb.toString()
}
