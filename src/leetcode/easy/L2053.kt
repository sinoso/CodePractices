package leetcode.easy

fun main() {

}

private fun kthDistinct(arr: Array<String>, k: Int): String {
    val map = LinkedHashMap<String, Int>()
    arr.forEach {
        map[it] = (map[it] ?: 0) + 1
    }
    var left = k

    for ((key, value) in map) {
        if (value == 1) {
            left--
            if (left == 0)
                return key
        }
    }
    return ""
}
