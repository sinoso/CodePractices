package leetcode.easy

fun main() {
    countTriples(10)
}

private fun countTriples(n: Int): Int {
    var count = 0
    val set = hashSetOf<Int>()
    for (i in 1..n) {
        set.add(i * i)
    }
    for (i in 1..n) {
        val iSquare = i * i
        for (j in i..n) {
            if (set.contains(iSquare + j * j)) {
                count++
            }
        }
    }
    return count * 2
}

private fun countTriples2(n: Int): Int {
    var count = 0
    for (v in 1..n) {
        for (i in 1..v) {
            for (j in i..v) {
                if (i * i + j * j == v * v) {
                    count++
                }
            }
        }
    }

    return count * 2
}