package programmers.p0


fun main() {

}

private fun solution(array: IntArray, n: Int): Int =
    array.sortedWith(compareBy<Int> { Math.abs(it - n) }
        .thenBy { it })
        .first()
