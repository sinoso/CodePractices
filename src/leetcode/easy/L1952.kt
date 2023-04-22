package leetcode.easy

import kotlin.math.sqrt

fun main() {
}

private fun isThree(n: Int): Boolean {
    if (n < 4)
        return false
    val root = sqrt(n.toDouble()).toInt()
    if (root * root < n)
        return false
    var i = 2
    while (i <= sqrt(root.toDouble()))
        if (root % i++ == 0)
            return false
    return true
}

