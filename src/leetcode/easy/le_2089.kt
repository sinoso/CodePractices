package leetcode.easy

import leetcode.testclass.TreeNode

private fun targetIndices(nums: IntArray, target: Int): List<Int> =
    nums.sorted()
        .foldIndexed(mutableListOf()) { index, list, i -> if (i == target) list.apply { add(index) } else list }

