package leetcode.easy

fun main() {

}

private fun findTheArrayConcVal(nums: IntArray): Long {
    var answer = 0L
    var l = 0
    var r = nums.lastIndex
    while (l < r) {
        val right = nums[r--]
        var temp = right
        var left = nums[l++].toLong()

        while (temp > 0) {
            temp /= 10
            left *= 10
        }
        answer += left + right
    }
    if (l == r) {
        answer += nums[l]
    }
    return answer
}

private fun findTheArrayConcVal2(nums: IntArray): Long {
    var answer = 0L
    var l = 0
    var r = nums.lastIndex
    while (l < r) {
        answer += (nums[l++].toString() + nums[r--]).toLong()
    }
    if (l == r) {
        answer += nums[l]
    }
    return answer
}