package leetcode.easy

fun main() {

}

private fun repeatedNTimes(nums: IntArray): Int {
    val set = HashSet<Int>()
    for (i in nums){
        if (!set.add(i))
            return i
    }
    return -1
}