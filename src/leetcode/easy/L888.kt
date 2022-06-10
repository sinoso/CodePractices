package leetcode.easy

fun main() {
}

private fun fairCandySwap(aliceSizes: IntArray, bobSizes: IntArray): IntArray {
    val aliceSize = aliceSizes.sum()
    val bobSize = bobSizes.sum()
    val bobSet = HashSet<Int>().apply {
        bobSizes.forEach { add(it) }
    }
    val diff = (aliceSize - bobSize) / 2
    val answerArray = IntArray(2)
    for (i in aliceSizes) {
        val target = i - diff
        if (bobSet.contains(target)) {
            answerArray[0] = i
            answerArray[1] = target
        }
    }
    return answerArray
}
