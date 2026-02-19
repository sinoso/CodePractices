package leetcode.easy

fun main() {
    countEven(30)
}

private fun countEven(num: Int): Int {
    var answer = 0
    for (i in 1..num) {
        var flag = false
        var left = i
        while (left > 0) {
            if ((left % 10 and 1) == 1)
                flag = !flag
            left /= 10
        }
        if (!flag) {
            println(i)
            answer++
        }
    }
    return answer
}