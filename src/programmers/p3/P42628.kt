package programmers.p3

import java.util.*


fun main() {
    solution(arrayOf("I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"))

}

// 16:35 ~ 17:05
private fun solution(operations: Array<String>): IntArray {
    val map = TreeMap<Int, Int>()
    for (s in operations) {
        //입력
        if (s[0] == 'I') {
            val key = s.substring(2).toInt()
            map[key] = (map[key] ?: 0) + 1
            continue
        }
        //제거
        if (map.isEmpty()) //비었다면 무시
            continue

        val (key, value) = if (s[2] == '-') map.firstEntry() else map.lastEntry()
        map[key] = value - 1
        if (value == 1) {
            map.remove(key)
        }
    }
    if (map.isEmpty())
        return intArrayOf(0, 0)
    return intArrayOf(map.lastKey(), map.firstKey())
}
