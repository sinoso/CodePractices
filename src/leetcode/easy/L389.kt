package leetcode.easy

fun main() {
    println(findTheDifference(s = "abcd", t = "abcde"))
    println(findTheDifference(s = "", t = "y"))
}

private fun findTheDifference(s: String, t: String): Char {
    val g1 = t.groupingBy { it }.eachCount()
    val g2 = s.groupingBy { it }.eachCount()

    for (entre in g1) {
        val g2Value = g2[entre.key] ?: return entre.key
        if (entre.value != g2Value)
            return entre.key
    }
    return ' '
}

private fun findTheDifference2(s: String, t: String): Char {
    var answer = t.last().toInt()
    for (idx in s.indices) {
        answer -= s[idx].toInt()
        answer += t[idx].toInt()
    }
    return answer.toChar()
}

private fun findTheDifference3(s: String, t: String): Char =
    (t.sumOf(Char::toInt) - s.sumOf(Char::toInt)).toChar()

private fun findTheDifference4(s: String, t: String): Char =
    (s + t).groupingBy { it }
        .eachCount()
        .entries
        .find { it.value and 1 == 1 }!!
        .key
