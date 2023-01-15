package leetcode.easy

fun main() {

}

private fun getRow(rowIndex: Int): List<Int> {
    val answer = mutableListOf(1)
    repeat(rowIndex) {
        val maxIndex = answer.lastIndex
        answer += 1
        for (i in maxIndex downTo 1) {
            answer[i] += answer[i - 1]
        }
    }
    return answer
}


//1
//1  1
//1  2  1
//1  3  3  1
//1  4  6  4  1
//1  5 10 10  5  1
//1  6 15 20 15  6  1

//1
//0  1
//0  1  1
//0  1  2  1
//0  1  3  3  1
//0  1  4  6  4  1
//0  1  5 10 10  5  1



