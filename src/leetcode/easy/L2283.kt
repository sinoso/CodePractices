package leetcode.easy

fun main() {
}

private fun digitCount(num: String): Boolean {
    val map = hashMapOf<Int, Int>()
    for (i in num.indices) {
        val value = num[i] - '0'
        map[i] = (map[i] ?: 0) + value
        if (map[i]!! < 0)
            return false
        map[value] = (map[value] ?: 0) - 1
    }
    return map.all { it.value == 0 }
}