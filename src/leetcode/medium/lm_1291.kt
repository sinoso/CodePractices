package leetcode.medium

fun main() {
    println(sequentialDigits(100, 300).joinToString())
    println(sequentialDigits(1000, 13000).joinToString())
    println(sequentialDigits(1, 1000000000).joinToString())
    println(sequentialDigits(1234, 1234).joinToString())
}

private fun sequentialDigits(low: Int, high: Int): List<Int> {
    val lowLength: Int = (Math.log10(low.toDouble()) + 1).toInt()
    val highLength: Int = (Math.log10(high.toDouble()) + 1).toInt()
    val answerList = mutableListOf<Int>()
    var startSeq = 0
    var acc = 0
    repeat(lowLength) {
        startSeq *= 10
        startSeq += it + 1
        acc *= 10
        acc += 1
    }
    for (i in lowLength..highLength) {
        var currentSeq = startSeq
        while (currentSeq % 10 != 0) {
            if (currentSeq in low..high)
                answerList.add(currentSeq)
            currentSeq += acc
        }
        startSeq = startSeq * 10 + (startSeq % 10) + 1
        acc *= 10
        acc += 1
    }
    return answerList
}

private fun sequentialDigits_TimeOut(low: Int, high: Int): List<Int> {
    return (low..high).filter {
        var currentVar = it / 10
        var lastValue = it % 10
        while (currentVar != 0) {
            (currentVar % 10).also {
                if (it + 1 != lastValue)
                    return@filter false
                lastValue = it
            }
            currentVar /= 10
        }
        true
    }
}
