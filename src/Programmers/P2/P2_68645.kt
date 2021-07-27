package Programmers.P2


fun main() {
    println(solution(10000).contentToString())
//    println(solution(5).contentToString())
//    println(solution(6).contentToString())
}

private fun solution(n: Int): IntArray {
    var answer = IntArray((1 + n) * n / 2)
    var lastIndex = 0
    var lastValue = 1
    var tries = 0
    var lastLine = 0

    while (tries < n) {
        when (tries % 3) {
            0 -> { //상 -> 하
                while (lastLine < n && answer[lastIndex + lastLine] == 0) {
                    lastIndex += lastLine
                    answer[lastIndex] = lastValue++
                    lastLine++
                }
            }
            1 -> { //좌 -> 우
                while (lastIndex < answer.lastIndex && answer[lastIndex + 1] == 0) {
                    lastIndex += 1
                    answer[lastIndex] = lastValue++
                }
            }
            2 -> { //하 -> 상
                while (answer[lastIndex - lastLine] == 0) {
                    lastIndex -= lastLine
                    answer[lastIndex] = lastValue++
                    lastLine--
                }
            }
        }
        tries++
    }
    return answer
}
