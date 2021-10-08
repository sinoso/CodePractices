package leetcode.medium


fun main() {

}

class Trie() {
    private val set = linkedSetOf<String>()
    fun insert(word: String) {
        set.add(word)
    }

    fun search(word: String): Boolean {
        return set.contains(word)
    }

    fun startsWith(prefix: String): Boolean {
        for (i in set)
            if (i.startsWith(prefix))
                return true
        return false
    }

}