package leetcode.hard

import java.util.*
import kotlin.collections.ArrayList

fun main() {

}

private fun employeeFreeTime(schedule: ArrayList<ArrayList<Interval>>): ArrayList<Interval> {
    val heap = PriorityQueue(compareBy<Interval> { it.start }.thenBy { it.end })
    for (list in schedule) {
        for (interval in list) {
            heap.add(interval)
        }
    }
    val list = ArrayList<Interval>()
    var lastTime = heap.poll().end
    var currentInterval: Interval
    while (heap.isNotEmpty()) {
        currentInterval = heap.poll()
        if (lastTime < currentInterval.start) {
            list.add(Interval(lastTime, currentInterval.start))
        }
        lastTime = lastTime.coerceAtLeast(currentInterval.end)
    }
    return list
}

private fun employeeFreeTime2(schedule: ArrayList<ArrayList<Interval>>): ArrayList<Interval> {
    val sorted = schedule.flatten().sortedWith(compareBy<Interval> { it.start }.thenBy { it.end })
    val list = ArrayList<Interval>()
    var lastTime = sorted.first().end
    for (interval in sorted) {
        if (lastTime < interval.start) {
            list.add(Interval(lastTime, interval.start))
        }
        lastTime = lastTime.coerceAtLeast(interval.end)
    }
    return list
}

class Interval(_start: Int, _end: Int) {
    var start: Int = _start
    var end: Int = _end
}
