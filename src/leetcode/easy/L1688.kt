package leetcode.easy

import printResult

fun main() {
    printResult(numberOfMatches(1), 0)
    printResult(numberOfMatches(2), 1)
    printResult(numberOfMatches(3), 2)
    printResult(numberOfMatches(4), 3)
    printResult(numberOfMatches(7), 6)
    printResult(numberOfMatches(14), 13)
}

private fun numberOfMatches(n: Int): Int {
    if (n == 1) return 0
    var answer = 0
    var leftTeams = n
    while (leftTeams > 1) {
        if (leftTeams and 1 == 1) {
            answer--
            leftTeams++
        }
        leftTeams /= 2
        answer += leftTeams
    }
    return answer
}
