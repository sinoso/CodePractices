package leetcode.easy

fun main() {

}

private class NumArray(nums: IntArray) {
    
    private val table = IntArray(nums.size)

    init {
        table[0] = nums[0]
        for (i in 1 until nums.size) {
            table[i] = nums[i] + table[i - 1]
        }
    }

    fun sumRange(left: Int, right: Int): Int = table[right] - if (left == 0) 0 else table[left - 1]
}