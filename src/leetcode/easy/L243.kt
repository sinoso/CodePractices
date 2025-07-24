package leetcode.easy

fun main() {

}

private fun shortestDistance(wordsDict: Array<String>, word1: String, word2: String): Int {
    var index1 = -30000
    var index2 = -30000
    var distance = 60000
    for (i in wordsDict.indices) {
        val word = wordsDict[i]
        if (word == word1) {
            index1 = i
            distance = distance.coerceAtMost(Math.abs(index2 - index1))
        }
        if (word == word2) {
            index2 = i
            distance = distance.coerceAtMost(Math.abs(index2 - index1))
        }
    }
    return distance
}