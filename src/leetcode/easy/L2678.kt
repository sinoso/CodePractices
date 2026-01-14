package leetcode.easy

fun main() {

}

private fun countSeniors(details: Array<String>): Int =
    details.count { it[it.lastIndex-3] > '6' || (it[it.lastIndex-3] >= '6' && it[it.lastIndex-2] > '0') }