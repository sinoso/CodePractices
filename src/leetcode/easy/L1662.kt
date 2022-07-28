package leetcode.easy

import printResult

fun main() {
    printResult(arrayStringsAreEqual(arrayOf("ab", "c"), arrayOf("a", "bc")), true)
}

private fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
    var w2 = ""
    var w2Index = 0
    var w2Length = 0
    val word2ArraySize = word2.size
    var word2ArrayIndex = 0
    for (i in word1.indices) {
        val w1 = word1[i]
        var w1Index = 0
        while (w1Index < w1.length) {
            if (w2Length == w2Index) {//w2 마지막 인덱스면
                if (word2ArrayIndex == word2ArraySize) {
                    return false
                }
                w2 = word2[word2ArrayIndex++]
                w2Length = w2.length
                w2Index = 0
            }

            if (w2[w2Index++] != w1[w1Index++])
                return false
        }
    }
    return w2Index==w2Length &&word2ArraySize==word2ArrayIndex
}
// 어떻게 할 것인가?
// word1을 순한 한다.
// 진행에 따라 word2를 계속 바꿔 가면서 체크 한다.
