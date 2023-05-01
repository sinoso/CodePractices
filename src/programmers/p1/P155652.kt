package programmers.p1

fun main() {
}

private fun solution(s: String, skip: String, index: Int): String {
    val skipSet = skip.map { it - 'a' }.toSet()
    val sb = StringBuilder()
    for (c in s) {
        var temp = c - 'a'
        var count = index
        while (count > 0) {
            temp++
            temp %= 26
            if (skipSet.contains(temp)) {
                continue
            }
            count--
        }
        sb.append('a' + temp)
    }
    return sb.toString()

}
