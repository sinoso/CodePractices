package leetcode.easy


fun main() {
    println(sumZero(1).joinToString())
    println(sumZero(3).joinToString())
    println(sumZero(4).joinToString())
    println(sumZero(5).joinToString())
}

private fun sumZero(n: Int): IntArray {
    val answer = IntArray(n)
    for (i in 1..n / 2) {
        val currentIdx = (i - 1) * 2
        answer[currentIdx] = i
        answer[currentIdx + 1] = -i
    }
    return answer
}
//1 | 2 3 | 4 5 | 6 7 | 8 9
//0 | 1 2 | 3 4 | 5 6 | 7 8
//0 | 1 1 | 2 2 | 3 3 | 4 4
//1 1 | 2 2 | 3 3 | 4 4 | 0
//1 1 | 0
