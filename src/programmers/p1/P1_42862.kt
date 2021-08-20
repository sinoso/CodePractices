package programmers

fun main() {
    println(solution(4, intArrayOf(3, 1, 2), intArrayOf(2, 4, 3)))
    println(solution(9, intArrayOf(2,4,7,8), intArrayOf(3,6,9)))
    println(solution(5, intArrayOf(2, 4), intArrayOf(3, 5)))
}

private fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var state = IntArray(n)
        //분실
        lost.forEach { v ->
            state[v - 1]--
        }
        //여벌
        reserve.forEach { v ->
            state[v - 1]++
        }
        for (i in state.indices) {
            when {
                state[i] == 1 -> {
                    if (i > 0) {
                        if (state[i - 1] == -1) {
                            state[i]--
                            state[i - 1]++
                        }
                    }
                    if (i < n && state[i] > 0)
                        if (i + 1 < n && state[i + 1] == -1) {
                            state[i]--
                            state[i + 1]++
                        }
                }
            }
        }
        return state.filter { v -> v >= 0 }.size
}