package leetcode.easy

import java.util.LinkedList
import java.util.Queue

fun main() {

}

private fun applyOperations(nums: IntArray): IntArray {
    val queue: Queue<Int> = LinkedList()
    var i = 0
    while (i < nums.lastIndex) {
        if (nums[i] == 0) {
            i++
            continue
        }
        if (nums[i] == nums[i + 1]) {
            queue.add(nums[i] * 2)
            i++
        } else {
            queue.add(nums[i])
        }
        i++
    }
    if (i == nums.lastIndex) {
        queue.add(nums.last())
    }
    val answer = IntArray(nums.size)
    i = 0
    while (queue.isNotEmpty()) {
        answer[i++] = queue.poll()
    }
    return answer
}