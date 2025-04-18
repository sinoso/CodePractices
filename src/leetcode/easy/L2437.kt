package leetcode.easy

fun main() {

}

private fun countTime(time: String): Int {
    if (time.count { it == '?' } == 0)
        return 1
    val h10 = time[0]
    val h = time[1]
    val m10 = time[4]
    val m = time[5]
    var answer = 1
    when {
        h10 == '?' && h == '?' -> {
            answer *= 24
        }

        h10 == '?' -> {
            if (h in '0'..'3') {
                answer *= 3
            } else {
                answer *= 2
            }
        }

        h == '?' -> {
            when (h10) {
                '2' -> answer *= 4
                else -> answer *= 10
            }
        }
    }

    if (m10 == '?') {
        answer *= 6
    }
    if (m == '?') {
        answer *= 10
    }
    return answer
}