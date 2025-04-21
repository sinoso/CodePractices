package leetcode.easy

fun main() {

}

private fun countSeniors(details: Array<String>): Int =
    details.count { it[12] > '6' || (it[12] > '6' && it[11] > '0') }