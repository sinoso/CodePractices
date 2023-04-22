package leetcode.easy

fun main() {
    println(fibfib.fib(0))
    println(fibfib.fib(1))
//    println(fibfib.fib(2))
//    println(fibfib.fib(3))
//    println(fibfib.fib(4))
//    println(fibfib.fib(5))
}

object fibfib {
    val map = HashMap<Int, Int>()
    fun fib(n: Int): Int {
        var first = 0
        var second = 1
        repeat(n) {
            second += first
            first = second - first
        }
        return first
    }

    fun fib2(n: Int): Int {
        if (n <= 1)
            return (n).also { map[it] = it }
        return map[n] ?: ((map[n - 1] ?: fib(n - 1)) + (map[n - 2] ?: fib(n - 2)))
    }
}

