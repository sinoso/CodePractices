package Programmers.P2

fun main() {
    println(solution(arrayOf(arrayOf("yellowhat", "headgear"), arrayOf("bluesunglasses", "eyewear"), arrayOf("green_turban", "headgear"))))
    println(solution(arrayOf(arrayOf("crowmask", "face"), arrayOf("bluesunglasses", "face"), arrayOf("smoky_makeup", "face"))))
}

private fun solution(clothes: Array<Array<String>>): Int {
    val map = HashMap<String, Int>()
    var answer = 1
    clothes.forEach {
        map[it[1]] = map.getOrDefault(it[1], 0) + 1
    }
    for (entries in map)
        answer *= entries.value+1
    return answer-1
}
