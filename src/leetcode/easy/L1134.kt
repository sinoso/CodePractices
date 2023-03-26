package leetcode.easy

fun main() {
    isArmstrong(123)
}

private fun isArmstrong(n: Int): Boolean {
    var sum = 0.0
    val s = n.toString()
    val length = s.length.toDouble()

    for (c in s) {
        sum += Math.pow((c - '0').toDouble(),length)
    }
    return n.toDouble() == sum
}