package programmers.p2

fun main() {
    println(solution("110010101001").contentToString())//3,8
    println(solution("01110").contentToString())//3,3
    println(solution("1111111").contentToString())//4,1
}

private fun solution(s: String): IntArray {
    var zeros = 0
    var tries = 0
    var string = s
    while (string != "1") {
        zeros += string.filter { v -> v == '0' }.length
        string = string.replace("0", "").length.toString(2)
        tries++
    }
    return intArrayOf(tries, zeros)
}