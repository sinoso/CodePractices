package leetcode.easy


fun main() {
    println(decompressRLElist(intArrayOf(1, 2, 3, 4)).joinToString())
}


private fun decompressRLElist(nums: IntArray) = ArrayList<Int>().run {
    for (i in nums.indices step 2)
        repeat(nums[i]) { this.add(nums[i + 1]) }
    this.toIntArray()
}

