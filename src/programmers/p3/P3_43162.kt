package programmers.p2


fun main() {
    println(solution(3, arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1))))
    println(solution(3, arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 1), intArrayOf(0, 1, 1))))
}


private fun solution(n: Int, computers: Array<IntArray>): Int {
    var answer = 0
    var list = (0 until n).toMutableList()
    var subList = mutableListOf<Int>()
    for (i in computers.indices) {
        if (list.contains(i)) {
            computers[i].forEachIndexed { index, v ->
                if (v == 1) {
                    if (list.contains(index))
                        subList.add(index)
                }
            }
            list.remove(i)
            subList.remove(i)

            while (subList.size > 0) {
                for (j in computers[subList[0]].indices) {
                    if (computers[subList[0]][j] == 1)
                        if (!subList.contains(j))
                            if (list.contains(j)) {
                                subList.add(j)
                            }
                }
                list.remove(subList[0])
                subList.removeAt(0)
            }
            answer++
        }
    }
    return answer
}