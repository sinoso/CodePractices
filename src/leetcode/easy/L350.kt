package leetcode.easy


fun main() {

}

private fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val map = HashMap<Int, Int>()
    for (i in nums1) {
        map[i] = (map[i] ?: 0) + 1
    }
    val answer = mutableListOf<Int>()
    for (i in nums2) {
        val value = map[i] ?: 0
        if (value > 0) {
            answer += i
            map[i] = value - 1
        }
    }
    return answer.toIntArray()
}