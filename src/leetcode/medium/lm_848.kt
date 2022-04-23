package leetcode.medium

import printResult

fun main() {
    printResult(shiftingLetters("abc", intArrayOf(3, 5, 9)), "rpl")
    printResult(shiftingLetters("abc", intArrayOf(1, 1, 26)), "ccc")
    printResult(
        shiftingLetters(
            "mkgfzkkuxownxvfvxasy", intArrayOf(
                505870226,
                437526072,
                266740649,
                224336793,
                532917782,
                311122363,
                567754492,
                595798950,
                81520022,
                684110326,
                137742843,
                275267355,
                856903962,
                148291585,
                919054234,
                467541837,
                622939912,
                116899933,
                983296461,
                536563513
            )
        ), "wqqwlcjnkphhsyvrkdod"
    )
}

private fun shiftingLetters(s: String, shifts: IntArray): String {
    val sb = StringBuilder()
    for (i in shifts.indices)
        shifts[i] %= 26
    for (i in shifts.lastIndex - 1 downTo 0)
        shifts[i] = ((shifts[i + 1] + shifts[i])%26)
    for (i in s.indices)
        sb.append('a' + (s[i] + shifts[i] - 'a') % 26)
    return sb.toString()
}

fun shiftingLetters2(s: String, shifts: IntArray): String {
    val sb = StringBuilder()
    var acc = 0
    for (i in s.lastIndex downTo 0) {
        acc += shifts[i]
        acc %= 26
        sb.insert(0, 'a' + (s[i] + acc - 'a') % 26)
    }
    return sb.toString()
}
