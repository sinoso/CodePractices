package programmers.p2


fun main() {
    println(solution(arrayOf(intArrayOf(1, 1, 0, 0), intArrayOf(1, 0, 0, 0), intArrayOf(1, 0, 0, 1), intArrayOf(1, 1, 1, 1))).joinToString())
//    println(solution(arrayOf(intArrayOf(1, 1), intArrayOf(1, 0))).joinToString())
}


private fun solution(arr: Array<IntArray>): IntArray {
    val answer = IntArray(2) // 0,1의 갯수가 담김
    sol(arr, answer, 0, 0, arr.lastIndex, arr.lastIndex)
    return answer
}

//재귀의 형태로 만들 것.
private fun sol(arr: Array<IntArray>, answer: IntArray, col1: Int, row1: Int, col2: Int, row2: Int) {
    if (row1 == row2 && col1 == col2)
        return answer.let { it[arr[col1][row1]] += 1 }

    val firstValue = arr[col1][row1]
    var flag = false
    for (col in col1..col2) {
        if (flag)
            break
        for (row in row1..row2) {
            flag = firstValue != arr[col][row]
            if (flag)
                break
        }
    }
    if (flag) {
        var halfR = row1 + (row2 - row1) / 2
        var halfC = col1 + (col2 - col1) / 2
        sol(arr, answer, col1, row1, halfC, halfR) //좌상
        sol(arr, answer, halfC + 1, row1, col2, halfR) //좌하
        sol(arr, answer, col1, halfR + 1, halfC, row2) //우상
        sol(arr, answer, halfC + 1, halfR + 1, col2, row2) //우하
        return
    }
    answer[arr[col1][row1]] += 1
}