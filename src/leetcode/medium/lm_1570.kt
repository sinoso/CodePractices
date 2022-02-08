package leetcode.medium

fun main() {
    println(SparseVector(intArrayOf(1, 0, 0, 2, 3)).dotProduct(SparseVector(intArrayOf(0, 3, 0, 4, 0))))//8
    println(SparseVector(intArrayOf(0, 1, 0, 0, 0)).dotProduct(SparseVector(intArrayOf(0, 0, 0, 0, 2))))//0
    println(SparseVector(intArrayOf(0, 1, 0, 0, 2, 0, 0)).dotProduct(SparseVector(intArrayOf(1, 0, 0, 0, 3, 0, 4))))//6
}

class SparseVector(val nums: IntArray) {
    fun dotProduct(vec: SparseVector): Int {
        var answer = 0
        for (idx in nums.indices)
            answer += nums[idx] * vec.nums[idx]
        return answer
    }
}

class SparseVector2(val nums: IntArray) {
    fun dotProduct(vec: SparseVector): Int =
        nums.indices.map { idx -> vec.nums[idx] * nums[idx] }.sum()
}

