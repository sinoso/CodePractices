package programmers.p1

fun main() {
}

private fun solution(s: String): IntArray {
    val answer = IntArray(s.length) { -1 }
    val map = HashMap<Char, Int>()
    for (i in s.indices) {
        if (map[s[i]] == null) {
            map[s[i]] = i
            continue
        }
        answer[i] = i - map[s[i]]!!
        map[s[i]] = i
    }
    return answer
}
