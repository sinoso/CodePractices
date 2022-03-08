package leetcode.medium

fun main() {
    println(findStrobogrammatic(1))
    println(findStrobogrammatic(2))
    println(findStrobogrammatic(3))
    println(findStrobogrammatic(4))
    println(findStrobogrammatic(5))
    println(findStrobogrammatic(14))
}

private fun findStrobogrammatic(n: Int): List<String> {
    if (n == 1)
        return listOf("0", "1", "8")
    var answerList = listOf("")
    if (n and 1 == 1)
        answerList = listOf("0", "1", "8")
    val fixs = listOf("0" to "0", "1" to "1", "8" to "8", "6" to "9", "9" to "6")
    val times = (n) / 2
    repeat(times) {
        answerList = if (it == times - 1)
            answerList.flatMap { seed -> fixs.drop(1).map { it.first + seed + it.second } }
        else
            answerList.flatMap { seed -> fixs.map { it.first + seed + it.second } }
    }
    return answerList
}
