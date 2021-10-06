package leetcode.medium

fun main() {
    println(findDuplicates(intArrayOf(4,3,2,7,8,2,3,1)))
}
fun findDuplicates(nums: IntArray): List<Int> = mutableListOf<Int>().also { list ->
        with<HashSet<Int>, Unit>(HashSet()) {
            nums.forEach {
                if (!add(it))
                    list.add(it)
            }
        }
    }

fun findDuplicates2(nums: IntArray): List<Int> {
    val list = mutableListOf<Int>()
    with(HashSet<Int>()){
        nums.forEach{
            if(!add(it))
                list.add(it)
        }
    }
    return list
}