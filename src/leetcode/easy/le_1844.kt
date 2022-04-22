package leetcode.easy

fun main() {
}

private fun replaceDigits(s: String): String {
    val sb = StringBuilder()
    val alphabetRange = 'a'..'z'
    for (index in s.indices) {
        if (s[index] !in alphabetRange)
            sb.append(s[index - 1] + (s[index] - '0'))
        else
            sb.append(s[index])
    }
    return sb.toString()
}

private fun replaceDigits2(s: String): String {
    val sb = StringBuilder()
    for (index in s.indices) {
        if (s[index].isDigit()) {
            sb.append((s[index - 1].toInt() + (s[index] - '0')).toChar())
        } else
            sb.append(s[index])
    }
    return sb.toString()
}
