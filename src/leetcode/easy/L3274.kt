package leetcode.easy

fun main() {

}

fun checkTwoChessboards(coordinate1: String, coordinate2: String): Boolean {
    val isFirstBlack = (coordinate1[0] - 'a') + (coordinate1[1] - '1')
    val isSecondBlack = (coordinate2[0] - 'a') + (coordinate2[1] - '1')
    return (isFirstBlack + isSecondBlack) and 1 == 0
}
