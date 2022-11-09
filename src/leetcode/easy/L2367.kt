package leetcode.easy

fun main() {

}

private fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
    val checkerSet = nums.toSet()
    var answer = 0
    for (i in 0..(nums.lastIndex - 2)) {
        if (checkerSet.contains(nums[i] + diff) && checkerSet.contains(nums[i] + diff * 2))
            answer++
    }
    return answer
}
