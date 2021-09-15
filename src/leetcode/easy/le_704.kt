package leetcode.easy

fun main() {
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), target = 9))
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), target = 2))
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), target = 13))

}

private fun search(nums: IntArray, target: Int): Int = recursion(nums, target, 0, nums.lastIndex)

fun recursion(nums: IntArray, target: Int, minPoint: Int, maxPoint: Int): Int {
    var half = (minPoint + maxPoint) / 2
    return when {
        minPoint > maxPoint ->
            -1
        nums[half] < target ->
            recursion(nums, target, ++half, maxPoint)
        nums[half] > target ->
            recursion(nums, target, minPoint, --half)
        else ->
            half
    }
}