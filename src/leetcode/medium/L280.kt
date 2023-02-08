package leetcode.medium

import java.util.*

fun main() {

}

private fun wiggleSort(nums: IntArray): Unit {
    val priorityQueue = PriorityQueue<Int>()
    nums.forEach(priorityQueue::add)
    var i = 0
    while (i < nums.size) {
        nums[i] = priorityQueue.poll()
        i += 2
    }
    if (i == nums.size + 1)
        i-=2
    i--

    while (i >= 0) {
        nums[i] = priorityQueue.poll()
        i -= 2
    }
}
// 0 1 2 3 4     0  2  4  6 8 10
