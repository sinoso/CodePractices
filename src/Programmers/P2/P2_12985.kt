package Programmers.P2

fun main() {
    println(solution(8, 4, 7))
}

private fun solution(n: Int, a: Int, b: Int): Int {
    var answer = 0
    var array = BooleanArray(n)
    var size = array.size
    array[a - 1] = true
    array[b - 1] = true
    while (size > 1) {
        answer++
        var index = 0
        for (i in 0 until size step 2) {
            var value = array[i] && array[i + 1]
            if (value) {
                size = 0
                break
            }
            array[index] = array[i] || array[i + 1]
            index++
        }
        size /= 2
    }
    return answer
}
