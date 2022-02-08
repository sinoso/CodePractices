package leetcode.medium

fun main() {
    println(SparseVector(intArrayOf(1, 0, 0, 2, 3)).dotProduct(SparseVector(intArrayOf(0, 3, 0, 4, 0))))//8
    println(SparseVector(intArrayOf(0, 1, 0, 0, 0)).dotProduct(SparseVector(intArrayOf(0, 0, 0, 0, 2))))//0
    println(SparseVector(intArrayOf(0, 1, 0, 0, 2, 0, 0)).dotProduct(SparseVector(intArrayOf(1, 0, 0, 0, 3, 0, 4))))//6
}

class SparseVector(nums: IntArray, private var nonzeroMap: HashMap<Int, Int> = HashMap()) {
    init {
        for (idx in nums.indices)
            if (nums[idx] != 0)
                nonzeroMap[idx] = nums[idx]
    }

    fun dotProduct(vec: SparseVector): Int {
        var answer = 0
        val largeMap: HashMap<Int, Int>
        val smallMap: HashMap<Int, Int>
        if (nonzeroMap.size > vec.nonzeroMap.size) {
            largeMap = nonzeroMap
            smallMap = vec.nonzeroMap
        } else {
            largeMap = vec.nonzeroMap
            smallMap = nonzeroMap
        }
        for (nonzero in smallMap)
            answer += (largeMap[nonzero.key] ?: continue) * nonzero.value
        return answer
    }
}

class SparseVector2(nums: IntArray) {
    private val nonzeroMap =
        nums.withIndex()
            .asSequence()
            .filter { it.value != 0 }
            .associate { it.index to it.value }

    fun dotProduct(vec: SparseVector2): Int {
        var answer = 0
        for (nonezero in nonzeroMap)
            answer += nonezero.value * (vec.nonzeroMap[nonezero.key] ?: 0)
        return answer
    }
}

class SparseVector3(val nums: IntArray) {
    fun dotProduct(vec: SparseVector3): Int {
        var answer = 0
        for (idx in nums.indices)
            answer += nums[idx] * vec.nums[idx]
        return answer
    }
}

class SparseVector4(val nums: IntArray) {
    fun dotProduct(vec: SparseVector4): Int =
        nums.indices.map { idx -> vec.nums[idx] * nums[idx] }.sum()
}

