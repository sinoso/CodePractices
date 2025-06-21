package leetcode.easy

fun main() {

}


private fun maxScore(s: String): Int {
    val countTable = IntArray(s.length)
    countTable[s.lastIndex] = if (s.last() == '1') 1 else 0
    for (i in (s.lastIndex - 1) downTo 0) {
        countTable[i] = countTable[i + 1] + if (s[i] == '1') 1 else 0
    }
    var zeroCount = if (s.first() == '0') 1 else 0
    var max = zeroCount + countTable[1]
    for (i in 1 until s.lastIndex) {
        if (s[i] == '0')
            zeroCount++
        if (zeroCount + countTable[i] > max) {
            max = zeroCount + countTable[i]
        }
    }
    return max
}