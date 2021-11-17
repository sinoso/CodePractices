package leetcode.easy

fun main() {
    println(hammingWeight("00000000000000000000000000001011".toInt(2)))
    println(hammingWeight("00000000000000000000000010000000".toInt(2)))
}

private fun hammingWeight(n: Int): Int {
    var bits = n
    var answer = 0
    while (bits != 0) {
        if (bits and 1 == 1)
            answer++
        bits = bits ushr 1
    }
    return answer
}

private fun hammingWeight2(n: Int): Int = n.toUInt().toString(2).filter { it == '1' }.length
