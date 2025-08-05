package leetcode.easy

fun main() {

}

private fun evenOddBit(n: Int): IntArray {
    val nToS = n.toString(2).reversed()
    val answer = intArrayOf(0, 0)
    for (index in nToS.indices) {
        if (nToS[index] == '1') {
            if (index and 1 == 1){
                answer[1]++
            }
            else
                answer[0]++
        }
    }
    return answer
}