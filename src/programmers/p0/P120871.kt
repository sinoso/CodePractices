package programmers.p0

fun main() {
//    solution(15)
    solution(10)
}

private fun solution(n: Int): Int {
    var i = 0
    repeat(n) {
        i++
        while (i % 3 == 0 || contains3(i))
            i++
    }
    return i
}

private fun contains3(n: Int): Boolean {
    var left = n
    while (left > 0) {
        if (left % 10 == 3)
            return true
        left /= 10
    }
    return false
}
