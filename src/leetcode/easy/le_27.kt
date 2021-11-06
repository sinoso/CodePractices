package leetcode.easy

fun main() {
    println(removeElement(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2))//5
    println(removeElement(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 5))//8
    println(removeElement(intArrayOf(), 5))//0
    println(removeElement(intArrayOf(1), 5))//1
    println(removeElement(intArrayOf(5), 5))//0
    println(removeElement(intArrayOf(3, 3), 3))//0
    println(removeElement(intArrayOf(4, 5), 5))//1
    println(removeElement(intArrayOf(4, 5, 5), 5))//1
}

private fun removeElement(nums: IntArray, `val`: Int): Int {
    var left = 0
    var right = nums.lastIndex
    while (left <= right) {
        if (nums[left] == `val`) {
            if (nums[right] == `val`)
                while (right > left && nums[right] != `val`)
                    right--
            nums[left] = nums[right--]
            continue
        }
        left++
    }
    return left
}

private fun removeElement2(nums: IntArray, `val`: Int): Int {
    if (nums.isEmpty())
        return 0
    if (nums.size == 1)
        return if (nums[0] == `val`) 0 else 1
    var left = 0
    var right = nums.lastIndex
    while (left < nums.size) {
        if (left > right)
            return left
        if (nums[left] != `val`) {
            left++
            continue
        }
        if (nums[right] == `val`) {
            right--
            continue
        }
        nums[left] = nums[right]
        nums[right] = `val`
    }
    return left
}
