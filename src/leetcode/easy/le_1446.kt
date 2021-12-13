package leetcode.easy

fun main() {
    println(maxPower("leetcode") == 2)
    println(maxPower("abbcccddddeeeeedcba") == 5)
    println(maxPower("triplepillooooow") == 5)
    println(maxPower("hooraaaaaaaaaaay") == 11)
    println(maxPower("tourist") == 1)
    println(maxPower("cc") == 2)
}

private fun maxPower(s: String): Int {
    var char = s[0]
    var answer = 0
    var temp = 0
    for (ch in s) {
        if (ch == char)
            temp++
        else {
            char = ch
            if (temp > answer)
                answer = temp
            temp = 1
        }
    }
    if (temp > answer)
        answer = temp
    return Math.max(answer,1)
}
