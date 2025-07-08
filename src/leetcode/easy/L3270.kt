package leetcode.easy

fun main() {

}

private fun generateKey(num1: Int, num2: Int, num3: Int): Int {
    var left1 = num1
    var left2 = num2
    var left3 = num3
    var key = 0
    var mod = 1
    repeat(4) {
        key += minOf(left1 % 10, left2 % 10, left3 % 10) * mod
        left1 /= 10
        left2 /= 10
        left3 /= 10
        mod *= 10
    }
    return key
}

private fun generateKey2(num1: Int, num2: Int, num3: Int): Int {
    var left1 = num1
    var left2 = num2
    var left3 = num3
    var key = 0
    key += minOf(left1 % 10, left2 % 10, left3 % 10)
    left1 /= 10
    left2 /= 10
    left3 /= 10
    key += minOf(left1 % 10, left2 % 10, left3 % 10) * 10
    left1 /= 10
    left2 /= 10
    left3 /= 10
    key += minOf(left1 % 10, left2 % 10, left3 % 10) * 100
    left1 /= 10
    left2 /= 10
    left3 /= 10
    key += minOf(left1 % 10, left2 % 10, left3 % 10) * 1000
    return key
}