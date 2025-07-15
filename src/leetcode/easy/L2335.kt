package leetcode.easy

fun main() {
    
}

private fun fillCups(amount: IntArray): Int {
    val (min, mid, max) = amount.sorted()
    if (max > min + mid) {
        return max
    }
    return (min + mid + max + 1) / 2
}