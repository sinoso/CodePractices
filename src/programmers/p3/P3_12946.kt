package programmers.p3


fun main() {
    println(solution(1).joinToString())
    println(solution(2).joinToString())
    println(solution(3).joinToString())
    println(solution(4).joinToString())
    println(solution(5).joinToString())
}


private fun solution(n: Int): Array<IntArray> {
    var answer = mutableListOf<IntArray>()
    hanoi(1, 3, n, answer)
    return answer.toTypedArray()
}

private fun hanoi(from: Int, to: Int, disks: Int, answer: MutableList<IntArray>) {
    if (disks == 1) {
        answer.add(intArrayOf(from, to))
        return
    }
    hanoi(from, 6 - from - to, disks - 1, answer)
    answer.add(intArrayOf(from, to))
    hanoi(6 - from - to, to, disks - 1, answer)
}