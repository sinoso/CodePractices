package leetcode.easy

import kotlin.math.abs

fun main() {

}

private fun findClosest(x: Int, y: Int, z: Int): Int =
    when {
        abs(z - x) > abs(z - y) -> 2
        abs(z - x) < abs(z - y) -> 1
        else->0
    }