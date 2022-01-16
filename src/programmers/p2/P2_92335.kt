package programmers.p2

import kotlin.math.sqrt

fun main() {
    println(solution(437674, 3))
    println(solution(110011, 10))
    println(solution(1000000, 10))
}

private fun solution(n: Int, k: Int): Int {
    var answer = 0
    val primesSet = HashSet<Long>()
    val splitedList = n.toString(k)
        .split("0")
        .filter { it != "" }
        .map { it.toLong() }
    splitedList.forEach {
        if (primesSet.contains(it))
            answer++
        else if (it != 1L) {
            var flag = true
            for (i in 2..sqrt(it.toDouble()).toInt())
                if (it % i == 0L) {
                    flag = false
                    break
                }
            if (flag) {
                primesSet.add(it)
                answer++
            }
        }
    }
    return answer
}
