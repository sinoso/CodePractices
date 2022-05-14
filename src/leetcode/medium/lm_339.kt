package leetcode.medium

fun main() {

}

private fun depthSum(nestedList: List<NestedInteger>): Int {
    var sum = 0
    for (ni in nestedList)
        sum += nestedSum(ni, 1)
    return sum
}

private fun nestedSum(nestedInteger: NestedInteger, depth: Int): Int {
    return if (nestedInteger.isInteger())
        nestedInteger.getInteger()!! * depth
    else {
        var sum = 0
        for (ni in nestedInteger.getList()!!)
            sum += nestedSum(ni, depth + 1)
        sum
    }
}
