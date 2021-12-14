package leetcode.medium

fun main() {
    println(findDuplicate(intArrayOf(1, 3, 4, 2, 2)) == 2)
    println(findDuplicate(intArrayOf(3, 1, 3, 4, 2)) == 3)
    println(findDuplicate(intArrayOf(1, 1)) == 1)
    println(findDuplicate(intArrayOf(1, 1, 2)) == 1)
}

private fun findDuplicate(nums: IntArray): Int {
    HashSet<Int>().apply {
        nums.forEach {
            if(!this.add(it))
                return it
        }
    }
    return nums[0]
}
private fun findDuplicate2(nums: IntArray): Int {
    var t = nums[0]
    var r = nums[0]
    do {
        t = nums[t]
        r = nums[nums[r]]
    } while (t != r)

    r = nums[0]
    while (t != r) {
        t = nums[t]
        r = nums[r]
    }

    return t
}
