package leetcode.easy


fun main() {
    val kL = KthLargest(3, intArrayOf(4, 5, 8, 2))
    println(kL.add(3))
}

class KthLargest(k: Int, nums: IntArray) {
    private val list = nums.sortedDescending().toMutableList()
    private val kth = k - 1

    fun add(`val`: Int): Int {
        val max = list.size
        var idx = 0
        while (idx < max) {
            if (`val` >= list[idx])
                break
            idx++
        }
        list.add(idx, `val`)
        list.joinToString(", ")
        return list[kth]
    }
}
