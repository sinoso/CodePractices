package leetcode.easy

fun main() {
    println(xorOperation(5, 0))//8
    println(xorOperation(4, 3))//8
    println(xorOperation(1, 7))//7
    println(xorOperation(10, 5))//2
}

private fun xorOperation(n: Int, start: Int): Int =
    (start until (start + n * 2) step 2).reduce { acc, i -> acc xor i }

private fun xorOperation2(n: Int, start: Int): Int =
    (1 until n).fold(start) { acc, value -> acc xor (start + 2 * value) }

private fun xorOperation3(n: Int, start: Int): Int =
    Array(n) { start + 2 * it }.drop(1).foldRight(start) { value, acc -> value xor acc }

private fun xorOperation4(n: Int, start: Int): Int {
    var answer = start
    repeat(n - 1) {
        answer = answer xor start + 2 * (it + 1)
    }
    return answer
}

private fun xorOperation5(n: Int, start: Int): Int {
    var answer = start
    var acc = start
    repeat(n - 1) {
        acc += 2
        answer = answer xor acc
    }
    return answer
}
