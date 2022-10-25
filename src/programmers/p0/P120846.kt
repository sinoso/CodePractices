package programmers.p0


fun main() {
   println(solution(10))
   println(solution(15))
}

private fun solution(n: Int): Int {
    if (n<2)
        return 0
    val array = IntArray(n + 1) { 1 }
    array[0] = 1
    array[1] = 1
    for (i in 2..n) {
        if (array[0] != 0) {
            var index = i + i
            while (index <= n) {
                array[index] = 0
                index += i
            }
        }
    }
    return array.count { it == 0 }
}
