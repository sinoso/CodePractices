package leetcode.easy

fun main() {

}

private fun isCircularSentence(sentence: String): Boolean {
    for (i in sentence.indices) {
        if (sentence[i] == ' ') {
            if (sentence[i - 1] != sentence[i + 1])
                return false
        }
    }
    return sentence.first() == sentence.last()
}