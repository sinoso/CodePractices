package leetcode.medium

import leetcode.testclass.TreeNode

fun main() {

}

private fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()
    search(root1, list1)
    search(root2, list2)
    val answer = mutableListOf<Int>()
    var first = 0
    val firstLast = list1.size
    var second = 0
    val secondLast = list2.size

    while (first < firstLast && second < secondLast) {
        if (list1[first] < list2[second]) {
            answer.add(list1[first++])
        } else {
            answer.add(list2[second++])
        }
    }
    while (first < firstLast) {
        answer.add(list1[first++])
    }
    while (second < secondLast) {
        answer.add(list1[second++])
    }

    return answer
}

private fun search(root: TreeNode?, list: MutableList<Int>) {
    root ?: return
    root.left?.let { search(it, list) }
    list.add(root.`val`)
    root.right?.let { search(it, list) }
}

val mutableList = mutableListOf<Int>()
private fun getAllElements2(root1: TreeNode?, root2: TreeNode?): List<Int> {
    search2(root1)
    search2(root2)
    return mutableList.sorted()
}

private fun search2(root: TreeNode?) {
    root ?: return
    mutableList.add(root.`val`)
    root.left?.let { search2(it) }
    root.right?.let { search2(it) }
}

