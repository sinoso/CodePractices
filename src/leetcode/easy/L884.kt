package leetcode.easy


fun main() {

}

private fun uncommonFromSentences(s1: String, s2: String): Array<String> =
    HashMap<String, Boolean>().apply {
        for (s in s1.split(' ')) {
            this[s] = this[s] == null
        }
        for (s in s2.split(' ')) {
            this[s] = this[s] == null
        }
    }.filter { it.value }.keys.toTypedArray()
