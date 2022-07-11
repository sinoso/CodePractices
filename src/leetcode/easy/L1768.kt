package leetcode.easy

fun main() {

}

private fun mergeAlternately(word1: String, word2: String): String {
    val diffSize = word1.length - word2.length
    val sb = StringBuilder()
    when {
        diffSize > 0 -> {
            for (i in word2.indices) {
                sb.append(word1[i])
                sb.append(word2[i])
            }
            sb.append(word1.subSequence(word2.length, word1.length))
        }
        diffSize == 0 -> {
            for (i in word2.indices) {
                sb.append(word1[i])
                sb.append(word2[i])
            }
        }
        diffSize < 0 -> {
            for (i in word1.indices) {
                sb.append(word1[i])
                sb.append(word2[i])
            }
            sb.append(word2.subSequence(word1.length, word2.length))
        }
    }
    return sb.toString()
}
