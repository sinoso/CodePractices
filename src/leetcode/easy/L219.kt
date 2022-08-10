package leetcode.easy

fun main() {

}

private fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val map = HashMap<Int, Int>()
    for (i in nums.indices) {
        val lastIndex = map[nums[i]] ?: i.also { map[nums[i]] = it }
        if (lastIndex == i)
            continue
        if (i - lastIndex <= k) {
            return true
        }
        map[nums[i]] = i
    }
    return false
}
