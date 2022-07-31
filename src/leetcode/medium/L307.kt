package leetcode.medium

fun main() {
    NumArray(intArrayOf(1, 3, 5)).apply {
        sumRange(0, 2)
        update(1, 2)
        update(0, 2)
    }
}

class NumArray(private val nums: IntArray) {

    fun update(index: Int, `val`: Int) {
        nums[index] = `val`
    }

    fun sumRange(left: Int, right: Int): Int =
        (left..right).fold(0) { acc, i -> acc + nums[i] }
}

class NumArray2(private val nums: IntArray) {
    private val presumed: IntArray = nums.copyOf()

    init {
        (1..presumed.lastIndex).forEach {
            presumed[it] += presumed[it - 1]
        }
    }

    fun update(index: Int, `val`: Int) {
        val lastValue = nums[index]
        val diff = lastValue - `val`
        (index..presumed.lastIndex).forEach { presumed[it] -= diff }
        nums[index] = `val`
    }

    fun sumRange(left: Int, right: Int): Int {
        if (left == 0) {
            return presumed[right]
        }
        return presumed[right] - presumed[left - 1]
    }
}
