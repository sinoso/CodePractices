package leetcode.medium

fun main() {
    println(singleNumber(intArrayOf(1, 2, 1, 3, 2, 5)).joinToString())
}

private fun singleNumber(nums: IntArray): IntArray {
    val hashMap = HashMap<Int, Boolean>()
    nums.forEach { hashMap[it] = hashMap[it]?.let { false } ?: true }
    return hashMap.filter { it.value }.keys.toIntArray()
}

private fun singleNumberSet(nums: IntArray): IntArray {
    val hashSet = HashSet<Int>()
    nums.forEach {
        if(!hashSet.add(it))
            hashSet.remove(it)
    }
    return hashSet.toIntArray()
}
