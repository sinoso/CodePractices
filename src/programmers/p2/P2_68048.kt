package programmers.p2

fun main() {
    println(solution(intArrayOf(1, 3, 2), intArrayOf(1, 2, 3)).contentToString())
}

private fun solution(enter: IntArray, leave: IntArray): IntArray {
    var enterIdx = 0
    var currentIdx: Int
    var currentResult: Int
    var resultMap = HashMap<Int, Int>()
    for (i in leave.indices) {
        currentIdx = enter.indexOf(leave[i])
        if (enterIdx < currentIdx)
            enterIdx = currentIdx
        enter[currentIdx] = 0
        currentResult = 0
        for (j in (0..enterIdx).reversed()) {
            if (enter[j] != 0) {
                currentResult++
                resultMap[enter[j]] = resultMap.getOrDefault(enter[j], 0) + 1
            }
        }
        resultMap[leave[i]] = resultMap.getOrDefault(leave[i], 0) + currentResult
    }
    return resultMap.map { it.value }.toIntArray()
}
