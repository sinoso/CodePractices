package leetcode.medium

fun main() {
    println(carPooling(arrayOf(intArrayOf(2, 1, 5), intArrayOf(3, 3, 7)), 4))
    println(carPooling(arrayOf(intArrayOf(2, 1, 5), intArrayOf(3, 3, 7)), 5))
}

private fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
    val personsInPlace = IntArray(1000) { 0 }
    trips.forEach {
        (it[1] until it[2]).forEach { currentPlace ->
            personsInPlace[currentPlace] += it[0]
            if (personsInPlace[currentPlace] > capacity)
                return false
        }
    }
    return true
}
