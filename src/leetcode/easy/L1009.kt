package leetcode.easy

fun main() {
    println(bitwiseComplement(5).also { print(it == 2) })
    println(bitwiseComplement(7).also { print(it == 0) })
    println(bitwiseComplement(0).also { print(it == 1) })
}

private fun bitwiseComplement(n: Int): Int {
    if (n == 0)
        return 1
    var left = n
    var answer = 0
    var acc = 1
    while (left >= 1) {
        if (left and 1 == 0)
            answer += acc
        acc *= 2
        left /= 2
    }
    return answer
}
