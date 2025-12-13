package leetcode.easy

fun main() {

}


private fun minimumOperations(nums: IntArray): Int = nums.count { it % 3 != 0 }
//1. 각 숫자들을 n%3시에 0이 되게해야한다.
// 나올수 있는 결과물 0 1 2
// 0 패스
// 1 1을 뺀다.
// 2 1을 더한다.
// 결국 0이 아니라면 모든 결과에 대해서 한번만 연산하면 된다. == 모든 3의 배수가 아닌 수를 찾으면 된다.
//2. 1회 연산마다 1을 더하거나 뺀다.
//3. 연산횟수를 최대한 줄인다.