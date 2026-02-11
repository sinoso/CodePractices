package leetcode.easy

fun main() {

}

private fun dominantIndices(nums: IntArray): Int {
    var sum = nums.last()
    var count = 1
    var answer = 0
    for (i in (0..(nums.size - 2)).reversed()) {
        if (nums[i] * count > sum) {
            answer++
        }
        sum += nums[i]
        count++
    }
    return answer
}