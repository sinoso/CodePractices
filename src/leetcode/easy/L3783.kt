package leetcode.easy

import kotlin.math.abs

fun main() {

}

private fun mirrorDistance(n: Int): Int {
  return  abs(n-n.toString().reversed().toInt())
}