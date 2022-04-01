package leetcode.medium

import printResult

fun main() {
    printResult(expand("{a,b}c{d,e}f"), arrayOf("acdf", "acef", "bcdf", "bcef"))
    printResult(expand("abcd"), arrayOf("abcd"))
}

private fun expand(s: String): Array<String> {
    val elementList = mutableListOf<List<Char>>()
    val tempList = mutableListOf<Char>()
    var flag = false
    //split
    for (ch in s) {
        if (ch == ',')
            continue
        if (ch == '{') {
            flag = true
            continue
        }
        if (ch == '}') {
            flag = false
            elementList.add(tempList.sorted())
            tempList.clear()
            continue
        }
        if (flag)
            tempList.add(ch)
        else
            elementList.add(listOf(ch))
    }
    return elementList
        .fold(mutableListOf(StringBuilder())) { acc, list ->
            acc.fold(mutableListOf()) { accList, sb ->
                accList.apply {
                    list.forEach { accList.add(StringBuilder(sb).append(it)) }
                }
            }
        }.map(StringBuilder::toString)
        .toTypedArray()
}
