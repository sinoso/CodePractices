package leetcode.easy

fun main() {

}

private fun percentageLetter(s: String, letter: Char): Int {
    var lCount = 0
    var count = 0
    for (c in s) {
        if (c == letter)
            lCount++
        count++
    }
    return lCount * 100 / count
}
