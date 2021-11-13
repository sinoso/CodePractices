package leetcode.easy


fun main() {
    println(isPowerOfTwo(5))
    println(isPowerOfTwo(4))
}

private fun isPowerOfTwo(n: Int): Boolean {
    if (n == 1)
        return true
    if (n % 2 == 1 || n < 0)
        return false
    if (n.toString(2).filter { it == '1' }.length == 1)
        return true
    return false
}
