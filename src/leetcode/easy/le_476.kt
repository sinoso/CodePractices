package leetcode.easy


fun main() {
    println(findComplement(5))
    println(findComplement(1))
    println(findComplement(0))
}

private fun findComplement(num: Int): Int {
    val str = num.toString(2)
    var multiplier = 1
    var answer = 0
    for (i in str.lastIndex downTo 0) {
        if (str[i] == '0')
            answer += multiplier
        multiplier = multiplier shl 1
    }
    return answer
}
