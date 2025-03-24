package leetcode.easy

fun main() {

}

private fun convertDateToBinary(date: String): String = date.split('-').joinToString("-") { it.toInt().toString(2) }