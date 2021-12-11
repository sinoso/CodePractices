package leetcode.hard

fun main() {
    println(nthMagicalNumber(5, 2, 4).also { println(it) } == 10)
    println(nthMagicalNumber(4, 2, 3).also { println(it) } == 6)
    println(nthMagicalNumber(1, 2, 3).also { println(it) } == 2)
    println(nthMagicalNumber(3, 6, 4).also { println(it) } == 8)
    println(nthMagicalNumber(10, 9, 4).also { println(it) } == 28)
    println(nthMagicalNumber(1000000000, 40000, 40000).also { println(it) } == 999720007)
}

private fun nthMagicalNumber(n: Int, a: Int, b: Int): Int {
    val newA = a.toLong()
    val newB = b.toLong()
    val min = minOf(newA, newB)
    val max = maxOf(newA, newB)
    if (max % min == 0L)
        return ((min * n) % 1000000007).toInt()
    val gcd = gcd(min, max)
    val lcm = newA * newB / gcd
    val minTimes = lcm / min
    val maxTimes = lcm / max
    val valuesInLcm = HashSet<Long>().apply {
        (1..minTimes).map { it * min }.forEach { add(it) }
        (1..maxTimes).map { it * max }.forEach { add(it) }
    }
    val size = valuesInLcm.size
    val share = n / size
    val remainder = n % size
    var answer = share * lcm
    val sorted = valuesInLcm.sortedBy { it }
    if (remainder != 0) answer += sorted[remainder - 1]
    return (answer % 1000000007).toInt()
}

fun gcd(num1: Long, num2: Long): Long {
    return if (num2 == 0L) num1 else gcd(num2, num1 % num2)
}
