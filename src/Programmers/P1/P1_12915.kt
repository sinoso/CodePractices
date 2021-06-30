package Programmers

import java.util.*

fun main() {
    println(solution(arrayOf("sun", "bed", "car"), 1).contentToString())
    println(solution(arrayOf("abce", "abcd", "cdx"), 2).contentToString())
}

private fun solution(strings: Array<String>, n: Int): Array<String> {
    strings.also { it ->
        it.sort()
        it.sortBy { it[n] }
    }
    return strings
}

private fun solution2(strings: Array<String>, n: Int): Array<String> {
    Arrays.sort(strings)
    for (i in strings.indices) {
        strings[i] = strings[i][n] + strings[i]
    }
    Arrays.sort(strings)
    for (i in strings.indices) {
        strings[i] = strings[i].substring(1)
    }
    return strings
}