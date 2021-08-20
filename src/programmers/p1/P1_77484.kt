package programmers

fun main() {
//    System.out.println(solution("abcde"))
    var result = solution(intArrayOf(31, 10, 45, 1, 6, 19), intArrayOf(31, 10, 45, 1, 6, 19))
    println(result[0])
    println(result[1])
}

private fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
    var zeros = 0
    var correct = 0
    for (num: Int in lottos) {
        if (num == 0) {
            zeros++
            continue
        } else
            if (win_nums.contains(num))
                correct++
    }
    return intArrayOf(if (correct + zeros > 1) 7 - correct - zeros else 6, if (correct > 1) 7 - correct else 6)
}