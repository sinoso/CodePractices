package leetcode.easy

fun main() {

    println(longestCommonPrefix(arrayOf("flower", "flow", "flight"))) //fl"
    println(longestCommonPrefix(arrayOf("a"))) //"a"
    println(longestCommonPrefix(arrayOf("dog", "racecar", "car"))) //""
    println(longestCommonPrefix(arrayOf(""))) //""
}

private fun longestCommonPrefix(strs: Array<String>): String {
    val sb = StringBuilder()
    var minLength = 200
    strs.forEach {
        if (minLength > it.length)
            minLength = it.length
    }
    for (i in 0 until minLength) {
        val ch = strs[0][i]
        strs.forEach {
            if (it[i] != ch)
                return sb.toString()
        }
        sb.append(ch)
    }
    return sb.toString()
}

private fun longestCommonPrefix2(strs: Array<String>): String {
    val sb = StringBuilder()
    val sorted = strs.sortedBy { it.length }
    val maxIdx = sorted.first().length - 1
    if (maxIdx < 0)
        return ""
    for (i in 0..maxIdx) {
        val ch = strs[0][i]
        if (strs.size != strs.filter { it[i] == ch }.size)
            break
        sb.append(ch)
    }
    return sb.toString()
}

private fun longestCommonPrefix3(strs: Array<String>): String {
    val sb = StringBuilder()
    val maxIdx = strs.minOf { it.length } - 1
    if (maxIdx == -1)
        return ""
    for (i in 0..maxIdx) {
        val ch = strs[0][i]
        if (strs.size != strs.filter { it[i] == ch }.size)
            break
        sb.append(ch)
    }
    return sb.toString()
}
