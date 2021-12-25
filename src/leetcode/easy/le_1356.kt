package leetcode.easy

fun main() {
    println(sortByBits(intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)).joinToString(","))
    println(sortByBits(intArrayOf(1024,512,256,128,64,32,16,8,4,2,1)).joinToString(","))
}

private fun sortByBits(arr: IntArray) =
    arr.sortedWith(compareBy<Int> { Integer.bitCount(it) }.thenBy { it }).toIntArray()

