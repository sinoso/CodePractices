package leetcode.easy


fun main() {
    println(getConcatenation(intArrayOf(1,2,3)).joinToString())
}



private fun getConcatenation(nums: IntArray): IntArray = nums+nums
private fun getConcatenation2(nums: IntArray): IntArray = intArrayOf(*nums,*nums)

