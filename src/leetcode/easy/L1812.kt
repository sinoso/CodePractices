package leetcode.easy

fun main() {

}

private fun squareIsWhite(coordinates: String): Boolean =
    (((coordinates[0] - 'a') + (coordinates[1] - '1')) and 1) == 1