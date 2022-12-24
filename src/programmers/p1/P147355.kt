package programmers.p1

fun main() {
    P147355.solution("3141592", "271")
}

class P147355 {
    companion object {
        fun solution(t: String, p: String): Int {
            val range = 0..t.length - p.length
            val pLength = p.length
            var answer = 0
            var flag = true
            for (i in range) {
                var currentIndex = 0
                while (flag && currentIndex < pLength) {
                    if (t[i + currentIndex] < p[currentIndex])
                        break
                    flag = t[i + currentIndex] == p[currentIndex++]
                }
                if (flag)
                    answer++
                flag = true
            }
            return answer
        }
    }
}
