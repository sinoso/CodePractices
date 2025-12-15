package leetcode.easy

fun main() {

}

private fun slowestKey(releaseTimes: IntArray, keysPressed: String): Char {
    var indexOfMax = 0
    var lastMaxDuration = releaseTimes.first()
    for (i in 1..releaseTimes.lastIndex) {
        val currentDuration = releaseTimes[i] - releaseTimes[i - 1]
        when {
            currentDuration > lastMaxDuration -> {
                lastMaxDuration = currentDuration
                indexOfMax = i
            }
            currentDuration == lastMaxDuration -> {
                if (keysPressed[i] > keysPressed[indexOfMax]) {
                    indexOfMax = i
                }
            }
        }
    }
    return keysPressed[indexOfMax]
}

private fun slowestKey2(releaseTimes: IntArray, keysPressed: String): Char {
    val differenceArray = releaseTimes.copyOf()
    for (i in differenceArray.lastIndex downTo 1) {
        differenceArray[i] -= differenceArray[i - 1]
    }
    var maxValueOfIndex = 0
    for (i in differenceArray.indices) {
        when {
            differenceArray[i] > differenceArray[maxValueOfIndex] ->
                maxValueOfIndex = i

            differenceArray[i] == differenceArray[maxValueOfIndex] ->
                if (keysPressed[i] > keysPressed[maxValueOfIndex])
                    maxValueOfIndex = i
        }
    }
    return keysPressed[maxValueOfIndex]
}