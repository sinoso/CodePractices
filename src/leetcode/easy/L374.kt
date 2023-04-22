package leetcode.easy


fun main() {

    println(guessNumber(2126753390))
}
private fun guessNumber(n: Int): Int {
    var left = 1
    var right = n
    while (left <= right) {
        val pivot = left + (right - left) / 2
        when (guess(pivot)) {
            -1 -> right = pivot - 1
            1 -> left = pivot + 1
            0 -> return pivot
        }
    }
    return n
}

val a = 1702766719
private fun guess(n: Int): Int = when {
    a == n -> 0
    a < n -> -1
    a > n -> 1
    else -> n
}
