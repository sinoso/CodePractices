package leetcode.easy

import printResult

fun main() {
    printResult(calculateTime(keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"), 4)
    printResult(calculateTime(keyboard = "pqrstuvwxyzabcdefghijklmno", word = "leetcode"), 73)
}

private fun calculateTime(keyboard: String, word: String): Int {
    var currentIndex = 0
    val keyMap = HashMap<Char, Int>().apply {
        var index = 0
        keyboard.forEach { this[it] = index++ }
    }
    var count = 0
    for (c in word) {
        val newIndex = keyMap[c]!!
        count += if (newIndex < currentIndex) currentIndex - newIndex else newIndex - currentIndex
        currentIndex = newIndex
    }
    return count
}

//fun calculateTime(keyboard: String, word: String): Int {
//    var currentIndex = 0
//    var count = 0
//    for (c in word) {
//        val newIndex = if (c < keyboard[0]) 26 + (c - keyboard[0]) else c - keyboard[0]
//        count += newIndex.coerceAtLeast(currentIndex) - newIndex.coerceAtMost(currentIndex)
//        currentIndex = newIndex
//    }
//    return count
//}
