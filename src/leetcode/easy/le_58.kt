package leetcode.easy

fun main() {
    println(lengthOfLastWord("Hello World"))//5
    println(lengthOfLastWord("   fly me   to   the moon  "))//4
    println(lengthOfLastWord("luffy is still joyboy"))//6
    println(lengthOfLastWord("a"))//1
}

private fun lengthOfLastWord(s: String): Int = s.split(" ").last { it.isNotBlank() }.length

private fun lengthOfLastWord2(s: String): Int {
    var answer = 0
    for (index in s.indices.reversed()) {
        if (s[index] != ' ') {
            answer++
            continue
        }
        if (answer == 0)
            continue
        if (s[index] == ' ')
            break
    } 
    return answer
}

private fun lengthOfLastWord3(s: String): Int {
    var answer = 0
    var currentIdx = s.lastIndex
    while (s[currentIdx] == ' ')
        currentIdx--
    for (i in currentIdx downTo 0) {
        if (s[currentIdx--] == ' ')
            break
        answer++
    }
    return answer
}
