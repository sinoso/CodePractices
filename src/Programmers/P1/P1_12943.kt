package Programmers

fun main() {
    println(solution(1))
    println(solution(6))
    println(solution(16))
    println(solution(626331))
}

private fun solution(num: Int): Int {
    var answer = 0
    var temp = num.toLong()
    while (temp != 1L && answer < 500) {
        if (temp % 2 == 0L)
            temp /= 2
        else {
            temp = temp * 3 + 1
        }
        answer++
    }
    return if (answer == 500) -1 else answer
}