package leetcode.easy

fun main() {
    println(reversePrefix("abcdefd", 'd')) //6
    println(reversePrefix("xyxzxe", 'z')) //6
}

private fun reversePrefix(word: String, ch: Char): String {
    var idx = 0
    //find targetIdx
    while (idx < word.length) {
        if (word[idx] == ch)
            break
        idx++
    }
    val splited = word.toCharArray()
    if (idx == splited.size)
        return word
    var left = 0
    var right = idx
    while (left < right) {
        val temp = splited[right]
        splited[right--] = splited[left]
        splited[left++] = temp
    }
    return String(splited)
}
