package programmers.p1

fun main() {
    solution(arrayOf("aya", "yee", "u", "maa"))
}

val ableRegex = "aya|ye|woo|ma".toRegex()
val unableRegex = "ayaaya|yeye|woowoo|mama".toRegex()
private fun solution(babbling: Array<String>): Int =
    babbling.count {
        !it.contains(unableRegex) && it.replace(ableRegex, "").isEmpty()
    }
