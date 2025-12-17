package leetcode.easy

fun main() {

}

private fun replaceElements(arr: IntArray): IntArray {
    val answer = arr.copyOf()
    var maxValue = arr.last()
    answer[answer.lastIndex] = -1
    for (i in (answer.lastIndex - 1) downTo 0) {
        answer[i] = maxValue
        if (maxValue < arr[i])
            maxValue = arr[i]
    }
    return answer
}