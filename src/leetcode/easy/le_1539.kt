package leetcode.easy


fun main() {
    println(findKthPositive(intArrayOf(2, 3, 4, 7, 11), 5))
    println(findKthPositive(intArrayOf(1, 2, 3, 4), 2))
}

private fun findKthPositive(arr: IntArray, k: Int): Int {
    var answer = 0
    var arrIdx = 0
    var count = 0
    for (number in 1..arr.size + k) {
        if (arrIdx < arr.size && arr[arrIdx] == number) {
            arrIdx++
            continue
        }
        count++
        if (count == k) {
            answer = number
            break
        }
    }
    return answer
}
