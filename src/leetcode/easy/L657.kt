package leetcode.easy

fun main() {

}

private fun judgeCircle(moves: String): Boolean {
    var countVertical = 0
    var countHorizontal = 0
    for (c in moves) {
        when (c) {
            'U' -> countVertical++
            'D' -> countVertical--
            'L' -> countHorizontal--
            'R' -> countHorizontal++
        }
    }
    return countHorizontal == 0 && countVertical == 0
}
