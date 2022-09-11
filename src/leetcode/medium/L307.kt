package leetcode.medium

import java.util.Arrays

fun main() {
    NumArray(intArrayOf(1, 3, 5)).apply {
        sumRange(0, 2)
        update(1, 2)
        update(0, 2)
    }
}

class NumArray(private val nums: IntArray) {
    private val segTree = Array(nums.size * 4) { 0 }

    init {
        buildWithRec(1, 0, nums.size - 1)
    }

    fun merge(a: Int, b: Int): Int {
        return a + b
    }

    fun buildWithRec(nodeIndex: Int, nodeLeftIndex: Int, nodeRightIndex: Int): Int {
        if (nodeLeftIndex == nodeRightIndex) {
            segTree[nodeIndex] = nums[nodeLeftIndex]
            return segTree[nodeIndex]
        }
        val mid = nodeLeftIndex + (nodeRightIndex - nodeLeftIndex) / 2
        val leftValue = buildWithRec(nodeIndex * 2, nodeLeftIndex, mid)
        val rightValue = buildWithRec(nodeIndex * 2 + 1, mid + 1, nodeRightIndex)
        segTree[nodeIndex] = merge(leftValue, rightValue)
        return segTree[nodeIndex]
    }

    fun queryRec(left: Int, right: Int, nodeIndex: Int, nodeLeftIndex: Int, nodeRightIndex: Int): Int {
        if (right < nodeLeftIndex || left > nodeRightIndex) {
            return 0
        }
        if (left <= nodeLeftIndex && right >= nodeRightIndex) {
            return segTree[nodeIndex]
        }
        val mid = nodeLeftIndex + (nodeRightIndex - nodeLeftIndex) / 2
        val leftValue = queryRec(left, right, nodeIndex * 2, nodeLeftIndex, mid)
        val rightValue = queryRec(left, right, nodeIndex * 2 + 1, mid + 1, nodeRightIndex)
        return merge(leftValue, rightValue)
    }

    fun updateRec(index: Int, newValue: Int, nodeIndex: Int, nodeLeftIndex: Int, nodeRightIndex: Int): Int {
        if (index < nodeLeftIndex || index > nodeRightIndex) {
            return segTree[nodeIndex]
        }
        if (nodeLeftIndex == nodeRightIndex) {
            segTree[nodeIndex] = newValue
            return segTree[nodeIndex]
        }
        val mid = nodeLeftIndex + (nodeRightIndex - nodeLeftIndex) / 2
        val leftValue = updateRec(index, newValue, nodeIndex * 2, nodeLeftIndex, mid)
        val rightValue = updateRec(index, newValue, nodeIndex * 2 + 1, mid + 1, nodeRightIndex)
        segTree[nodeIndex] = merge(leftValue, rightValue)
        return segTree[nodeIndex]
    }


    fun update(index: Int, `val`: Int) {
        updateRec(index, `val`, 1, 0, nums.size - 1)
    }

    fun sumRange(left: Int, right: Int): Int {
        return queryRec(left, right, 1, 0, nums.size - 1)
    }
}

class NumArray2(private val nums: IntArray) {

    fun update(index: Int, `val`: Int) {
        nums[index] = `val`
    }

    fun sumRange(left: Int, right: Int): Int =
        (left..right).fold(0) { acc, i -> acc + nums[i] }
}

class NumArray3(private val nums: IntArray) {
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
