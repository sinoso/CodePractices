package leetcode.medium

fun main() {
//    println(intArrayOf(1, 2, 3, 4, 5, 6, 7).also { leetcode.medium.rotate(it, 3) }.joinToString())
    println(intArrayOf(-1, -100, 3, 99).also { rotate(it, 2) }.joinToString())
//    println(intArrayOf(1,2).also { leetcode.medium.rotate(it, 3) }.joinToString())
//    println(intArrayOf(1, 2, 3).also { leetcode.medium.rotate(it, 4) }.joinToString())


}

fun rotate(nums: IntArray, k: Int): Unit {
    val point = nums.size - k % nums.size
    val temp = nums.slice(0 until point)
    var point2 = 0
    for (i in point..nums.lastIndex)
        nums[point2++] = nums[i]
    for (i in temp)
        nums[point2++] = i
}
