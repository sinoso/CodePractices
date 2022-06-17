package leetcode.easy

import java.util.LinkedList
import java.util.Queue

fun main() {

}

private fun minMaxGame(nums: IntArray): Int {
    val queue = LinkedList<Int>() as Queue<Int>
    nums.forEach { queue.add(it) }
    var isMinTime = true
    while (queue.size>1){
        if (isMinTime){
            queue.add(queue.poll().coerceAtMost(queue.poll()))
        }else{
            queue.add(queue.poll().coerceAtLeast(queue.poll()))
        }
        isMinTime=!isMinTime
    }
    return queue.poll()
}
