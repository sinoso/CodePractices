package leetcode.easy


fun main() {
    calculateTime(keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba")
}

private fun calculateTime(keyboard: String, word: String): Int {
    val keymap = HashMap<Char, Int>()
    for (i in keyboard.indices) {
        keymap[keyboard[i]] = i
    }
    var currentIdx = 0
    var answer = 0
    for (c in word) {
        val nextIndex = keymap[c]!!
        answer += Math.abs(nextIndex - currentIdx)
        currentIdx = nextIndex
    }
    return answer
}
