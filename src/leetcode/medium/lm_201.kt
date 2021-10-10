package leetcode.medium

fun main() {
    println(rangeBitwiseAnd(5, 7))
}

private fun rangeBitwiseAnd(left: Int, right: Int): Int {
    var answer = right
    for (i in (right-1) downTo left ) {
        answer = answer and i
        if (answer == 0)
            return 0
    }
    return answer
}