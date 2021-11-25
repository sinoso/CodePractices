package leetcode.easy

fun main() {
    println(balancedStringSplit("RLRRLLRLRL"))
    println(balancedStringSplit("RLLLLRRRLR"))
    println(balancedStringSplit("LLLLRRRR"))
    println(balancedStringSplit("RLRRRLLRLL"))
    println(balancedStringSplit("LR"))
}

private fun balancedStringSplit(s: String): Int {
    var answer = 0
    var count = 0
    s.forEach {
        count += if (it == 'L') 1 else -1
        if (count == 0)
            answer++
    }
    return answer
}
