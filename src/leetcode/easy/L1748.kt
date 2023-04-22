package leetcode.easy

fun main() {
    println(sumOfUnique(intArrayOf(1, 2, 3, 2)))
    println(sumOfUnique(intArrayOf(1, 1, 1, 1, 1)))
}

private fun sumOfUnique(nums: IntArray): Int {
    var sum = 0
    HashMap<Int, Boolean>().also {
        nums.forEach { value ->
            val entryValue = it[value]
            if (entryValue == null) {
                it[value] = true
                sum += value
            } else if (entryValue == true) {
                it[value] = false
                sum -= value
            }
        }
    }
    return sum
}

private fun sumOfUnique2(nums: IntArray): Int = HashMap<Int, Int>().also {
    nums.forEach { value ->
        it[value] = it.getOrDefault(value, 0) + 1
    }
}.filter { it.value == 1 }.map { it.key }.sum()

