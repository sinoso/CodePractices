package programmers.p0

fun main() {

}

private fun solution(my_string: String): Int {
    val list = my_string
        .split(" ")
    var answer = list.first().toInt()
    for (i in 1..list.lastIndex step 2) {
        val operator = list[i]
        val newValue = list[i + 1].toInt()
        if (operator == "+")
            answer += newValue
        else
            answer -= newValue
    }
    return answer
}
