package leetcode.easy

fun main() {

}

private fun removeOuterParentheses(s: String): String {
    val sb = StringBuilder()
    var count = 0
    for (c in s) {
        if (c == '(') {
            if (count != 0)
                sb.append(c)
            count++
        } else {
            if (count != 1)
                sb.append(c)
            count--
        }
    }
    return sb.toString()
}
