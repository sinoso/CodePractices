package programmers.p2

fun main() {
    println(solution(3))
    println(solution(5))
    println(solution(100000))
}

private fun solution(n: Int): Int {
    var beforeLastValue = 0
    var lastValue = 1
    var temp = 0
    if (n == 1)
        return 1
    for (i in 0..(n - 2)) {
        temp = (beforeLastValue + lastValue) % 1234567
        beforeLastValue = lastValue
        lastValue = temp
    }
    return lastValue
}

private fun solution2(n: Int): Int {
    var answer = 0
    var fibonacci: MutableList<Int> = ArrayList()
    fibonacci.add(0)
    fibonacci.add(1)
    for (i in 0..(n - 2)) {
        fibonacci.add((fibonacci[fibonacci.lastIndex] + fibonacci[fibonacci.lastIndex - 1]) % 1234567)
    }
    return fibonacci.last()
}