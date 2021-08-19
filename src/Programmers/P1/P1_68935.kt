package Programmers

fun main() {
    println(solution(45))
    println(solution(125))
}

private fun solution(n: Int): Int {
    var value = n
    var answer= 0
    var rest = 0
    val array = arrayListOf<Int>()
    var multi = 1
    while (value > 0) {
        rest = value % 3
        array.add(rest)
        value /= 3
    }
    for (a in array.reversed()) {
        answer += multi * a
        multi *= 3
    }
    return answer
}