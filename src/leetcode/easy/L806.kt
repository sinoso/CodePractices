package leetcode.easy


fun main() {

}

private fun numberOfLines(widths: IntArray, s: String): IntArray {
    var lineCount = 1
    var currentLinePixels = 0
    val maxPixelForLine = 100
    for (c in s) {
        val indexOfChar = c - 'a'
        val pixelsForCurrentChar = widths[indexOfChar]
        currentLinePixels += pixelsForCurrentChar
        if (currentLinePixels>maxPixelForLine) {
            lineCount++
            currentLinePixels = pixelsForCurrentChar
        }
    }
    return intArrayOf(lineCount,currentLinePixels)
}

