package leetcode.easy

import kotlin.math.log10
import kotlin.math.pow

fun main() {

    println(isPalindrome(121)) //2
    println(isPalindrome(-121)) //2
}

private fun isPalindrome(x: Int): Boolean {
    if (x < 0)
        return false
    val xLength = log10(x.toDouble())
    var left = (10).toDouble()
    var right = (10).toDouble().pow((xLength + 1))
    while (left < right){
        if((x/left) != (x/right))
            return false
    }
}

private fun isPalindrome1(x: Int): Boolean {
    if (x < 0)
        return false
    var r = 0 // 뒤집은 결과 정수
    var n = x // 뒤집은 결과 정수
    while (n != 0) {
        r *= 10
        r += n % 10
        n /= 10
    }
    return r == x
}

private fun isPalindrome2(x: Int): Boolean {
    if (x < 0)
        return false
    val s = x.toString()
    var left = 0
    var right = s.lastIndex
    while (left < right)
        if (s[left++] != s[right--])
            return false
    return true
}
