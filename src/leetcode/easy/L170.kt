package leetcode.easy

import kotlin.math.abs

fun main() {
    TwoSum().also {
        it.add(2)
        it.find(2)
    }
}

private class TwoSum() {
    val table = HashMap<Int, Int>()

    fun add(number: Int) {
        table[number] = (table[number] ?: 0) + 1
    }

    fun find(value: Int): Boolean {
        if (abs(value) > 200_000) {
            return false
        }

        for ((number, countOfNumber) in table) {
            val left = value - number
            if (left == number && countOfNumber < 2) {
                continue
            }
            if (table[left] != null) {
                return true
            }
        }
        return false
    }

}
