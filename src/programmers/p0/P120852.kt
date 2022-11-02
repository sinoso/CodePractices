package programmers.p0


fun main() {

}

private fun solution(n: Int): IntArray {
    val availableSet: MutableSet<Int> = mutableSetOf()
    var left = n
    var current = 2
    while (left != 1) {
        if (left % current != 0) {
            current++
            continue
        }
        availableSet.add(current)
        left /= current
    }
    return availableSet.toIntArray().apply(IntArray::sort)
}
