package leetcode.medium


fun main() {
//    println(reverse("9646324351".toInt()))
//    println(reverse("1534236469".toInt()))
    println(reverse("123".toInt()))
}

fun reverse(x: Int): Int {
    val sign = if (x >= 0) 1 else -1
    val s = x.toString()
    var idx = 0
    val sb = StringBuilder()
    if (sign == -1) idx++
    for (i in s.lastIndex downTo idx)
        sb.append(s[i])
    if (sign == -1)
        sb.insert(0, "-")
    val answer = sb.toString()
    if (answer.toLong() > Int.MAX_VALUE.toLong() || answer.toLong() < Int.MIN_VALUE.toLong())
        return 0
    return sb.toString().toInt()
}
