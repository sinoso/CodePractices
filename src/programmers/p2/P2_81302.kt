package programmers.p2

fun main() {
    println(solution(arrayOf(arrayOf
    (
            "POOOP",
            "OXXOX",
            "OPXPX",
            "OOXOX",
            "POXXP"),
            arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
            arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
            arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
            arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"))).contentToString())
}

private fun solution(places: Array<Array<String>>): IntArray {
    var answer = IntArray(places.size)
    for (placeNum in places.indices) {
        var place = places[placeNum]
        var flag = true
        for (i in place.indices) {
            for (j in place[0].indices) {
                if (!flag)
                    break
                if (place[i][j] == 'P')
                    flag = check(place, i, j, 0, 0)
            }
            if (!flag)
                break
        }
        answer[placeNum] = if (flag) 1 else 0
    }
    return answer
}

private fun check(place: Array<String>, i: Int, j: Int, skip: Int, depth: Int): Boolean {
    //아래 확인 1
    var result = true
    if (result && skip != 1 && i < place.lastIndex)
        when (place[i + 1][j]) {
            'P' -> return false
            'O' -> if (depth == 0) result = check(place, i + 1, j, 0, 1)
        }
    //왼쪽 확인 2
    if (result && skip != 2 && j > 0)
        when (place[i][j - 1]) {
            'P' -> return false
            'O' -> if (depth == 0) result = check(place, i, j - 1, 3, 1)
        }
    //오른쪽 확인 3
    if (result && skip != 3 && j < place[0].lastIndex)
        when (place[i][j + 1]) {
            'P' -> return false
            'O' -> if (depth == 0) result = check(place, i, j + 1, 2, 1)
        }
    //전부 아닐시
    return result
}