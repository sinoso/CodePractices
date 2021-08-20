package programmers

fun main() {
    println(solution(intArrayOf(1, 2, 3, 4)))
    println(solution(intArrayOf(1, 2, 7, 6, 4)))
}

private fun solution(nums: IntArray): Int {
    //최대값 = 3000
    //에라토스테네스의 체
    var primes = IntArray(3001) { v -> v }
    primes[1] = 0
    for (i in 2..primes.lastIndex) {
        if (primes[i] != 0) {
            for (j in i + i..primes.lastIndex step i) {
                if (primes[j] == 0)
                    continue
                else
                    primes[j] = 0
            }
        }
    }
    //값 조합
    var primeSet = primes.toHashSet()
    var valueSet = ArrayList<Int>()
    for (i in nums.indices)
        for (j in (i + 1)..nums.lastIndex)
            for (k in (j + 1)..nums.lastIndex) {
                valueSet.add(nums[i] + nums[j] + nums[k])
            }
    return valueSet.filter { v -> primeSet.contains(v) }.size
}