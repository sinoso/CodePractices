package leetcode.medium

fun main() {
    println(findMaxLength(intArrayOf(0, 1)))
    println(findMaxLength(intArrayOf(0, 1, 0)))
//    println(findMaxLength(intArrayOf(0, 1, 0)))
//    println(findMaxLength(intArrayOf(1, 0, 1)))
//    println(findMaxLength(intArrayOf(1, 1, 0, 0)))
}

private fun findMaxLength(nums: IntArray): Int {
    var max = 0
    var count = 0
    val map = HashMap<Int, Int>().apply {
        this[0] = -1// 주석 1
    }
    nums.indices.forEach { index ->
        count += if (nums[index] == 0) -1 else +1
        map[count]?.let { value ->
            max = max.coerceAtLeast(index - value)
        } ?: run {
            map[count] = index
        }
    }
    return max
}
/* 주석 1 왜 key = 0, index = -1 을 가지는가?
count가 0일 경우에 가져올수 있는 인덱스가 없기 떄문이다.
해당 솔루션은 count가 증감되며선 해당 count를 가진 인덱스를 가져와서 항상 같은 0,1갯수를 갖는지 확인한다.
이때 처음부터 계속 0,1이 반복될경우 count는 0이 된다.
이런경우 최초 시작지점이 한번 반복 되고 나서 진행되기에 ex-> 0,2
전체 크기가 어긋나게 된다. 이를 방지하기 위해 최초에 값을 추가해 둔다.
*/
