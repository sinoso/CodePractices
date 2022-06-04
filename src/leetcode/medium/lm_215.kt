package leetcode.medium

import printResult
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main() {
//    printResult(findKthLargest(intArrayOf(3,2,1,5,6,4),2),5)
    printResult(findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4), 4)
}

private fun findKthLargest(nums: IntArray, k: Int): Int {
    val map = HashMap<Int, Int>()
    val heap = PriorityQueue<Int>(compareByDescending { it })
    nums.forEach { value ->
        if (map[value] == null) {
            heap.add(value)
            map[value] = 1
        }else {
            map[value] = map[value]!! + 1
        }
    }
    var left = k
    var lastValue = 0
    while (left>0){
        lastValue = heap.poll()
        left -= map[lastValue]!!
    }
    return lastValue
}

private fun findKthLargest2(nums: IntArray, k: Int): Int {
    val set = HashSet<Int>()
    val heap = PriorityQueue<Int>(compareByDescending { it })
    nums.forEach {
        heap.add(it)
    }
    repeat(k - 1) {
        heap.poll()
    }
    return heap.poll()
}
