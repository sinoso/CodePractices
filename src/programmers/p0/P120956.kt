package programmers.p0

fun main() {
    println(solution(arrayOf("aya", "yee", "u")))
    println(solution(arrayOf("ayaye", "uuu", "yeye", "yemawoo", "ayaayaa")))
}

val map = listOf("aya" to 1, "ye" to 2, "woo" to 3, "ma" to 4).toMap()
private fun solution(babbling: Array<String>): Int {
    var answer = 0
    val sb = StringBuilder()
    babbling.forEach {
        var last = 0
        sb.setLength(0)
        for (c in it) {
            sb.append(c)
            if (sb.length == 4)
                return@forEach
            val current = map[sb.toString()] ?: continue
            if (last == current)
                return@forEach
            last = current
            sb.setLength(0)
        }
        if (sb.isNotEmpty())
            return@forEach
        answer++
    }
    return answer
}
