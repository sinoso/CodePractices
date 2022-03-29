fun <T> printResult(
    actual: T,
    expected: T,
    equalChecker: (actual: T, expected: T) -> Boolean = { it1, it2 -> it1 == it2 },
) =
    println(actual.also {
        if (equalChecker(actual, expected)) print("pass ") else print("fail ")
        print("expected = $expected , actual = ")
    })
fun  printResult(
    actual: IntArray,
    expected: IntArray,
    equalChecker: (actual: IntArray, expected: IntArray) -> Boolean = { it1, it2 -> it1 == it2 },
) =
    println(actual.joinToString(", ").also {
        if (equalChecker(actual, expected)) print("pass ") else print("fail ")
        print("expected = ${expected.joinToString(", ")} , actual = ")
    })

fun <T> printResult(actual: Array<T>, expected: Array<T>) = printResult(actual, expected, ::arrayChecker)
fun printResult(actual: IntArray, expected: IntArray) = printResult(actual, expected, ::intArrayChecker)

private fun <T> arrayChecker(actual: Array<T>, expected: Array<T>): Boolean {
    if (actual.size != expected.size)
        return false
    for (i in actual.indices)
        if (actual[i] != expected[i])
            return false
    return true
}

private fun intArrayChecker(actual: IntArray, expected: IntArray): Boolean {
    if (actual.size != expected.size)
        return false
    for (i in actual.indices)
        if (actual[i] != expected[i])
            return false
    return true
}
