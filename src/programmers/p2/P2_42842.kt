package programmers.p2

fun main() {
    println(solution(10, 2).contentToString())
    println(solution(8, 1).contentToString())
    println(solution(24, 24).contentToString())
    println(solution(4994, 1556256).contentToString())
}

private fun solution(brown: Int, yellow: Int): IntArray {
    var nBrown = (brown - 4) / 2
    var w = 0
    var h = 0
    for (i in 1..nBrown) {
        if ((nBrown - i) * i == yellow) {
            w = nBrown - i
            h = i
            break
        }
    }
    return intArrayOf(w + 2, h + 2)
}
