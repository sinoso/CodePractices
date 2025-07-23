package leetcode.easy

fun main() {

}

private fun vowelStrings(words: Array<String>, left: Int, right: Int): Int {
    var count = 0
    val vowelSet = hashSetOf('a', 'e', 'i', 'o', 'u')
    for (i in left..right) {
        val word = words[i]
        if (word.first() in vowelSet && word.last() in vowelSet)
            count++
    }
    return count
}