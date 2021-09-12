package programmers.p3


fun main() {
    println(solution(1))
    println(solution(2))
    println(solution(3))
    println(solution(4))
    println(solution(5))
    println(solution(5))
}


private fun solution(n: Int): Long {
    if (n == 1)
        return 1
    if (n == 2)
        return 2
    var array = Array(n + 1) { 0L }
    array[1] = 1
    array[2] = 2
    for (i in 3..n)
        array[i] = (array[i - 1] + array[i - 2]) % 1234567
    return array[n]
}