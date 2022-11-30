package leetcode.easy

fun main() {
    commonFactors(25, 30)
}

private fun commonFactors(a: Int, b: Int): Int {
    val min = a.coerceAtMost(b)
    val max = a.coerceAtLeast(b)
    val root = Math.sqrt(min.toDouble()).toInt()
    var count = 0
    val used = HashSet<Int>()
    for (i in 1..root) {
        if (min % i == 0) {
            if (used.add(i) && max % i == 0) {
                count++
            }
            val large = min / i
            if (used.add(large) && max % large == 0)
                count++
        }
    }
    return count
}

