package leetcode.easy

fun main() {
    println(reverseOnlyLetters("ab-cd"))
    println(reverseOnlyLetters("a-bC-dEf-ghIj"))
    println(reverseOnlyLetters("Test1ng-Leet=code-Q!"))
    println(reverseOnlyLetters("7_28]"))
}

private fun reverseOnlyLetters(s: String): String {
    val array = s.toCharArray()
    var left = 0
    var right = array.lastIndex
    while (left < right) {
        if (!array[left].isLetter()) {
            left++
            continue
        }
        if (!array[right].isLetter()) {
            right--
            continue
        }
        val temp = array[left]
        array[left] = array[right]
        array[right] = temp
        left++
        right--
    }
    return String(array)
}

private fun reverseOnlyLetters2(s: String): String {
    val array = s.toCharArray()
    var left = 0
    var right = array.lastIndex
    while (left < right) {
        if (array[left] !in 'A'..'Z' && array[left] !in 'a'..'z') {
            left++
            continue
        }
        if (array[right] !in 'A'..'Z' && array[right] !in 'a'..'z') {
            right--
            continue
        }
        val temp = array[left]
        array[left] = array[right]
        array[right] = temp
        left++
        right--
    }
    return String(array)
}
