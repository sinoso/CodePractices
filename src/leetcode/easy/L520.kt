package leetcode.easy

fun main() {
    println(detectCapitalUse("USA"))//t
    println(detectCapitalUse("FlaG"))//f
    println(detectCapitalUse("leetcode"))//t
    println(detectCapitalUse("leetcodE"))//f
    println(detectCapitalUse("Google"))//t
    println(detectCapitalUse("FFf"))//f
    println(detectCapitalUse("mL"))//f
}

private fun detectCapitalUse(word: String): Boolean {
    var upper = 0
    var isLowerChecked = false
    for (ch in word) {
        if (ch in 'a'..'z') {
            if (upper > 1)
                return false
            isLowerChecked = true
            continue
        }
        upper++
        if (isLowerChecked)
            return false
    }
    return true
}

private fun detectCapitalUse3(word: String): Boolean {
    val iterator = word.iterator()
    var upper = 0
    var lower = 0
    while (iterator.hasNext()) {
        if (iterator.next() in 'A'..'Z') {
            if (lower > 0)
                return false
            upper++
        } else
            lower++
        if (upper > 1 && lower > 0)
            return false
    }
    return true
}

