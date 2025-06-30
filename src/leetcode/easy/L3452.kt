package leetcode.easy

fun main() {

}

private fun sumOfGoodNumbers(nums: IntArray, k: Int): Int {
    var answer = 0
    for (i in nums.indices) {
        if (i - k >= 0 && nums[i] <= nums[i - k]) {
            continue
        }
        if (i + k < nums.size && nums[i] <= nums[i + k]) {
            continue
        }
        answer += nums[i]
    }
    return answer
}