package leetcode.medium

import java.util.LinkedList


fun main() {
}

private
fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    if(intervals.isEmpty()) return arrayOf(newInterval)
    val list = LinkedList<IntArray>()
    var newStart = newInterval[0]
    var newEnd = newInterval[1]
    for (i in intervals.indices) {
        val range = intervals[i]
        if (range[1] < newStart) { //-> newinterval 전
            list.add(range)
            continue
        }

        val thisRange = range[0]..range[1]
        if (newStart in thisRange) {
            newStart = thisRange.first
            if (newEnd in thisRange) {
                newEnd = thisRange.last
            }
            continue
        }

        if (newEnd in thisRange) {
            newEnd = thisRange.last
            continue
        }
        if (newEnd < thisRange.first) {
            if (list.isEmpty() || list.last[1] < newEnd) {
                list.add(intArrayOf(newStart, newEnd))
            }
            list.add(range)
        }
    }
    if (list.isEmpty()||list.last[1]<newStart){
        list.add(intArrayOf(newStart, newEnd))
    }
    return list.toTypedArray()
}


//새거 안에
