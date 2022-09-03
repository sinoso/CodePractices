package leetcode.easy

import printResult

fun main() {
    printResult(countPoints("B0B6G0R6R0R6G9"), 1)
    printResult(countPoints("B9R9G0R4G6R8R2R9G9"), 1)
}

private fun countPoints(rings: String): Int {
    val map = HashMap<Char, Array<Boolean>>()
    var colorIndex = 0
    var numberIndex = 1
    while (numberIndex <= rings.lastIndex) {
        when (rings[colorIndex]) {
            'R' -> map[rings[numberIndex]] = (map[rings[numberIndex]] ?: Array(3) { false }).apply { this[0] = true }
            'G' -> map[rings[numberIndex]] = (map[rings[numberIndex]] ?: Array(3) { false }).apply { this[1] = true }
            'B' -> map[rings[numberIndex]] = (map[rings[numberIndex]] ?: Array(3) { false }).apply { this[2] = true }
        }
        numberIndex += 2
        colorIndex += 2
    }
    return map.filter { (_, b) -> b[0] && b[1] && b[2] }.size
}
