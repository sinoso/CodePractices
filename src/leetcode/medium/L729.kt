package leetcode.medium

import java.util.*

fun main() {

}

class MyCalendar() {
    val map = TreeMap<Int, Int>()

    fun book(start: Int, end: Int): Boolean {
        val beforeStartMax = map.floorKey(start) // beforeThisStarts.max <= start
        if (beforeStartMax != null && start < map[beforeStartMax]!!)
            return false
        val afterStartMin = map.ceilingKey(start)// -> start <=afterThisStarts in min
        if (afterStartMin != null && end > afterStartMin)
            return false
        map[start] = end
        return true
    }
}
