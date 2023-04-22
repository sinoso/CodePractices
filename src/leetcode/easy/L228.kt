package leetcode.easy


fun main() {
    println(summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7)).joinToString())
    println(summaryRanges(intArrayOf(0, 1, 2, 4, 6, 7)).joinToString())
    println(summaryRanges(intArrayOf(0, 1, 2, 4, 5)).joinToString())
    println(summaryRanges(intArrayOf(0, 1, 3)).joinToString())
    println(summaryRanges(intArrayOf(0, 2)).joinToString())
    println(summaryRanges(intArrayOf(0, 1)).joinToString())
    println(summaryRanges(intArrayOf(0)).joinToString())
    println(summaryRanges(intArrayOf()).joinToString())
    println(summaryRanges(intArrayOf(-2147483648, -2147483647, 2147483647)).joinToString())
}

private fun summaryRanges(nums: IntArray): List<String> {
    if (nums.isEmpty())
        return emptyList()
    val answer = mutableListOf<String>()
    var start = nums[0]
    var last = nums[0]
    var i = 1
    while (i < nums.size) {
        if (last + 1 == nums[i]) {
            last = nums[i]
            i++
            continue
        }
        if (last == start)
            answer.add("$start")
        else
            answer.add("$start->$last")
        start = nums[i]
        last = nums[i]
        i++
    }
    if (last == start)
        answer.add("$start")
    else
        answer.add("$start->$last")
    return answer
}

private fun summaryRanges2(nums: IntArray): List<String> {
    if (nums.isEmpty())
        return emptyList()
    val answer = mutableListOf<String>()
    var idx = 0
    var last = 0L
    var start = 0L
    val sb = StringBuilder()
    while (idx < nums.size) {
        if (sb.isEmpty()) {
            start = nums[idx].toLong()
            sb.append(nums[idx])
        } else
            if (nums[idx] - last > 1) {
                if (start != last)
                    sb.append("->$last")
                answer.add(sb.toString())
                sb.clear()
                continue
            }
        last = nums[idx].toLong()
        idx++
    }
    if (start != last)
        sb.append("->$last")
    answer.add(sb.toString())
    return answer
}
